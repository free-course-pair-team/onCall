package oncall.controller

import oncall.domain.CalendarGenerator
import oncall.model.DayOfWeek

class Controller(private val inputController: InputController, private val calendarGenerator: CalendarGenerator) {
    fun run() {
        val monthAndStartOfWeek = inputController.getMonthAndStartDayOfWeek()
        val allWorkers = inputController.getWorkers()
        val month = monthAndStartOfWeek.first
        val startOfWeek = mapStartOfWeekToDayOfWeek(monthAndStartOfWeek.second)
        calendarGenerator.generateCalendar(month, startOfWeek)
    }

    fun mapStartOfWeekToDayOfWeek(startOfWeek: String): DayOfWeek {
        when (startOfWeek) {
            DayOfWeek.일.name -> return DayOfWeek.일
            DayOfWeek.월.name -> return DayOfWeek.월
            DayOfWeek.화.name -> return DayOfWeek.화
            DayOfWeek.수.name -> return DayOfWeek.수
            DayOfWeek.목.name -> return DayOfWeek.목
            DayOfWeek.금.name -> return DayOfWeek.금
            else -> return DayOfWeek.토
        }
    }
}
