package oncall.domain

import oncall.model.DailyOnCall

class OnCallWorkerGenerator {

    fun generateOnCallWorker(
        workSchedule: MutableList<DailyOnCall>,
        weekForce: MutableList<String>,
        weekendForce: MutableList<String>,
    ): List<DailyOnCall> {
        var previousWorker: String? = null
        return workSchedule.map {
            val currentWorker = getCurrentWorker(
                previousWorker ?: "",
                it.isWeekendAndHoliday,
                weekendForce,
                weekForce
            )

            val workers =
                getWeekendsOrWeekdaysWorkers(it.isWeekendAndHoliday, weekendForce, weekForce)

            workers.add(currentWorker)
            previousWorker = currentWorker
            it.copy(worker = currentWorker)
        }
    }

    private fun getCurrentWorker(
        previousWorker: String,
        isWeekendAndHoliday: Boolean,
        weekendForce: MutableList<String>,
        weekForce: MutableList<String>,
    ): String {
        val willCurrentWorker = getWillCurrentWorker(isWeekendAndHoliday, weekendForce, weekForce)
        return generateBackupWorker(
            previousWorker == willCurrentWorker,
            willCurrentWorker,
            isWeekendAndHoliday,
            weekendForce,
            weekForce
        )
    }

    private fun getWillCurrentWorker(
        isWeekendAndHoliday: Boolean,
        weekendForce: MutableList<String>,
        weekForce: MutableList<String>,
    ): String {
        if (isWeekendAndHoliday) {
            return weekendForce.removeFirst()
        }
        return weekForce.removeFirst()
    }

    private fun generateBackupWorker(
        isIdenticalWorker: Boolean,
        currentWorker: String,
        isWeekendAndHoliday: Boolean,
        weekendForce: MutableList<String>,
        weekForce: MutableList<String>,
    ): String {
        if (isIdenticalWorker) {
            return popNextWorker(currentWorker, isWeekendAndHoliday, weekendForce, weekForce)
        }
        return currentWorker
    }

    private fun popNextWorker(
        currentWorker: String,
        isWeekendAndHoliday: Boolean,
        weekendForce: MutableList<String>,
        weekForce: MutableList<String>,
    ): String {
        val workers = getWeekendsOrWeekdaysWorkers(isWeekendAndHoliday, weekendForce, weekForce)
        val currentAssignWorker = workers.removeFirst()
        workers.add(FIRST_INDEX, currentWorker)
        return currentAssignWorker
    }

    private fun getWeekendsOrWeekdaysWorkers(
        isWeekendAndHoliday: Boolean,
        weekendForce: MutableList<String>,
        weekForce: MutableList<String>,
    ): MutableList<String> {
        if (isWeekendAndHoliday) return weekendForce
        return weekForce
    }

    companion object {
        const val FIRST_INDEX = 0
    }
}
