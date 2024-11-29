package oncall.domain

import oncall.model.DailyOnCall
import oncall.model.Worker

class OnCallWorkerGenerator {

    fun generateOnCallWorker(
        workSchedule: MutableList<DailyOnCall>,
        weekForce: MutableList<Worker>,
        weekendForce: MutableList<Worker>,
    ): List<DailyOnCall> {
        var previousWorker: Worker? = null
        return workSchedule.map {
            val currentWorker = getCurrentWorker(
                previousWorker,
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
        previousWorker: Worker?,
        isWeekendAndHoliday: Boolean,
        weekendForce: MutableList<Worker>,
        weekForce: MutableList<Worker>,
    ): Worker {
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
        weekendForce: MutableList<Worker>,
        weekForce: MutableList<Worker>,
    ): Worker {
        if (isWeekendAndHoliday) {
            return weekendForce.removeFirst()
        }
        return weekForce.removeFirst()
    }

    private fun generateBackupWorker(
        isIdenticalWorker: Boolean,
        currentWorker: Worker,
        isWeekendAndHoliday: Boolean,
        weekendForce: MutableList<Worker>,
        weekForce: MutableList<Worker>,
    ): Worker {
        if (isIdenticalWorker) {
            return popNextWorker(currentWorker, isWeekendAndHoliday, weekendForce, weekForce)
        }
        return currentWorker
    }

    private fun popNextWorker(
        currentWorker: Worker,
        isWeekendAndHoliday: Boolean,
        weekendForce: MutableList<Worker>,
        weekForce: MutableList<Worker>,
    ): Worker {
        val workers = getWeekendsOrWeekdaysWorkers(isWeekendAndHoliday, weekendForce, weekForce)
        val currentAssignWorker = workers.removeFirst()
        workers.add(FIRST_INDEX, currentWorker)
        return currentAssignWorker
    }

    private fun getWeekendsOrWeekdaysWorkers(
        isWeekendAndHoliday: Boolean,
        weekendForce: MutableList<Worker>,
        weekForce: MutableList<Worker>,
    ): MutableList<Worker> {
        if (isWeekendAndHoliday) return weekendForce
        return weekForce
    }

    companion object {
        const val FIRST_INDEX = 0
    }
}
