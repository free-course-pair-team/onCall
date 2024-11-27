package oncall

class OnCallController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val (month, startDayOfWeek) = retryInput { inputView.readMonthAndDayOfWeek() }
        val (weekDayWorkersName, holidayWorkersName) = retryInput {
            val weekDayWorkersName = inputView.readWeekDayWorkersName()
            val holidayWorkersName = inputView.readHolidayWorkersName()
            Pair(weekDayWorkersName, holidayWorkersName)
        }
        val emergencyMonth = getEmergencyMonth(weekDayWorkersName, holidayWorkersName, month, startDayOfWeek)
        outputView.printResult(emergencyMonth)
    }

    private fun getEmergencyMonth(
        weekDayWorkersName: List<String>,
        holidayWorkersName: List<String>,
        month: Month,
        startDayOfWeek: DayOfWeek
    ): EmergencyMonth {
        var currentWeekDayWorkIndex = 0
        var currentHolidayWorkIndex = 0
        var currentDayOfWeek = startDayOfWeek
        val emergencyDays = month.days.map { day ->
            val isPublicHoliday = PublicHolidays.isPublicHoliday(month.month, day)
            if (currentDayOfWeek.isHoliday || isPublicHoliday) {
                val emergencyDay = EmergencyDay(
                    holidayWorkersName[currentHolidayWorkIndex % weekDayWorkersName.size],
                    currentDayOfWeek,
                    day,
                    isPublicHoliday
                )
                currentDayOfWeek = currentDayOfWeek.nextDayOfWeek()
                currentHolidayWorkIndex++
                emergencyDay
            } else {
                val emergencyDay = EmergencyDay(
                    weekDayWorkersName[currentWeekDayWorkIndex % weekDayWorkersName.size],
                    currentDayOfWeek,
                    day
                )
                currentDayOfWeek = currentDayOfWeek.nextDayOfWeek()
                currentWeekDayWorkIndex++
                emergencyDay
            }
        }
        return EmergencyMonth(month.month, emergencyDays)
    }
}