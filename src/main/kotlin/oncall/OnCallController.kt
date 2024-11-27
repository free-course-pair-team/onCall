package oncall

import java.util.LinkedList

class OnCallController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val (month, startDayOfWeek) = retryInput { inputView.readMonthAndDayOfWeek() }
        val (weekDayWorkersName, holidayWorkersName) = retryInput {
            val weekDayWorkersName = inputView.readWeekDayWorkersName()
            val holidayWorkersName = inputView.readHolidayWorkersName()
            Pair(WorkerManager(weekDayWorkersName), WorkerManager(holidayWorkersName))
        }
        val emergencyMonth = getEmergencyMonth(weekDayWorkersName, holidayWorkersName, month, startDayOfWeek)
        outputView.printResult(emergencyMonth)
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
            currentDayOfWeek = currentDayOfWeek.nextDayOfWeek()
            previousWorkerName = workerName
            EmergencyDay(workerName, currentDayOfWeek, day, isPublicHoliday)
        }
        return EmergencyMonth(month.month, emergencyDays)
    }

    private fun isDayOff(dayOfWeek: DayOfWeek, isPublicHoliday: Boolean) =
        dayOfWeek.isHoliday || isPublicHoliday
}