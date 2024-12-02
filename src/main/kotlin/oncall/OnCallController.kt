package oncall

import java.util.LinkedList

class OnCallController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val (month, startDayOfWeek) = retryInput { getMonthOrDayOfWeek(inputView.readMonthAndDayOfWeek()) }
        val (weekDayWorkersName, holidayWorkersName) = retryInput {
            val weekDayWorkersName = inputView.readWeekDayWorkersName()
            val holidayWorkersName = inputView.readHolidayWorkersName()
            Pair(WorkerManager(weekDayWorkersName), WorkerManager(holidayWorkersName))
        }
        val emergencyMonth = getEmergencyMonth(weekDayWorkersName, holidayWorkersName, month, startDayOfWeek)
        outputView.printResult(emergencyMonth)
    }

    private fun getMonthOrDayOfWeek(monthAndDayOfWeek: List<String>): Pair<Month, DayOfWeek> {
        require(monthAndDayOfWeek.size == 2) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        val (monthInput, dayOfWeekInput) = monthAndDayOfWeek
        val monthNumber = requireNotNull(monthInput.toIntOrNull()) { "[ERROR] 비상 근무 월은 1에서 12의 정수를 입력해 주세요." }
        require(monthNumber in 1..12) { "[ERROR] 비상 근무 월은 1에서 12의 정수를 입력해 주세요." }
        require(dayOfWeekInput in DayOfWeek.entries.map { it.text }) { "[ERROR] 요일은 월 화 수 목 금 토 일 만 입력해 주세요" }
        return Pair(Month.convertMonth(monthNumber), DayOfWeek.convertDayOfWeek(dayOfWeekInput))
    }

    private fun getEmergencyMonth(
        weekDayWorkers: WorkerManager, holidayWorkers: WorkerManager, month: Month, startDayOfWeek: DayOfWeek
    ): EmergencyMonth {
        var currentDayOfWeek = startDayOfWeek
        var previousWorkerName = ""
        val emergencyDays = month.days.map { day ->
            val isPublicHoliday = PublicHolidays.isPublicHoliday(month.month, day)
            val workerName =
                if (isDayOff(currentDayOfWeek, isPublicHoliday)) holidayWorkers.getWorkerName(previousWorkerName)
                else weekDayWorkers.getWorkerName(previousWorkerName)
            val emergencyDay = EmergencyDay(workerName, currentDayOfWeek, day, isPublicHoliday)
            currentDayOfWeek = currentDayOfWeek.nextDayOfWeek()
            previousWorkerName = workerName
            emergencyDay
        }
        return EmergencyMonth(month.month, emergencyDays)
    }

    private fun isDayOff(dayOfWeek: DayOfWeek, isPublicHoliday: Boolean) =
        dayOfWeek.isHoliday || isPublicHoliday
}