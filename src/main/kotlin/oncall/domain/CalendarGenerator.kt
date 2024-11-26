package oncall.domain

import oncall.model.DailyInfo
import oncall.model.DayOfWeek
import oncall.model.Holiday
import oncall.model.MontlyStartAndEndDay

class CalendarGenerator {
    fun generateCalendar(month: Int, startDayOfWeek: DayOfWeek): List<DailyInfo> {
        val calendar = mutableListOf<DailyInfo>()
        val daysOfWeek = DayOfWeek.entries.toTypedArray()
        var daysOfWeekIndex = startDayOfWeek.ordinal
        val targetMonth = findTargetMonth(month)

        for (day in targetMonth.start..targetMonth.end) {
            val dayOfWeek = findDayOfWeek(index = daysOfWeekIndex)
            val isHoliday = isHoliday(month, day)
            calendar.add(DailyInfo(targetMonth.month, day, dayOfWeek, null, isHoliday))
            daysOfWeekIndex = (daysOfWeekIndex + 1) % daysOfWeek.size
        }
        return calendar
    }

    fun findTargetMonth(month: Int): MontlyStartAndEndDay {
        return MontlyStartAndEndDay.entries.get(month - 1) //0번째 인덱스 고려
    }

    fun findDayOfWeek(index: Int): DayOfWeek {
        return DayOfWeek.entries.get(index)
    }

    //반복문을 제거하는 방향으로 리팩토링 예정
    fun isHoliday(month: Int, day: Int): Boolean {
        val holidays = Holiday.entries
        holidays.forEach { holiday ->
            if (month == holiday.month && day == holiday.day) {
                return true
            }
        }
        return false
    }
}
