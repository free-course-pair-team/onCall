package oncall.domain

import oncall.model.DailyOnCall
import oncall.model.Holiday
import oncall.model.MonthlyStartAndEndDay
import oncall.model.Week

class OnCallMonthGenerator {
    fun generateOnCallMonth(month: Int, startDay: Week): List<DailyOnCall> {
        val result = mutableListOf<DailyOnCall>()
        val week = Week.entries
        var index = Week.entries.indexOf(startDay)
        val targetMonth = MonthlyStartAndEndDay.entries.get(month - 1)
        for (date in targetMonth.start..targetMonth.end) {
            val isHoliday = isHoliday(month, date)
            val day = week.get(index)
            result.add(DailyOnCall(month, date, day, null, isHoliday(month, date), isWeekendAndHoliday(isHoliday, day)))
            index = (index + 1) % week.size
        }
        return result
    }

    fun isHoliday(month: Int, date: Int): Boolean {
        Holiday.entries.forEach {
            if (it.month == month && it.date == date) {
                return true
            }
        }
        return false
    }

    fun isWeekendAndHoliday(isHoliday: Boolean, day: Week): Boolean {
        return isHoliday == true || day in listOf(Week.SAT, Week.SUN)
    }
}

