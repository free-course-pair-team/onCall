package oncall.domain

import oncall.model.DailyOnCall

class OnCallWorkerGenerator {

    fun generateOnCallWorker(
        workSchedule: MutableList<DailyOnCall>,
        weekForce: MutableList<String>,
        weekendForce: MutableList<String>
    ): List<DailyOnCall> {
        var previousWorker: String? = null
        return workSchedule.map {
            var currentWorker: String? = null

            if (it.isWeekendAndHoliday) {
                currentWorker = weekendForce.removeFirst()
            } else {
                currentWorker = weekForce.removeFirst()
            }

            if (previousWorker == currentWorker) {
                var twoDaysWorker = ""
                if (it.isWeekendAndHoliday) {
                    twoDaysWorker = currentWorker
                    currentWorker = weekendForce.removeFirst()
                    weekendForce.add(0, twoDaysWorker)
                } else {
                    twoDaysWorker = currentWorker
                    currentWorker = weekForce.removeFirst()
                    weekForce.add(0, twoDaysWorker)
                }
            }

            if (it.isWeekendAndHoliday) {
                weekendForce.add(currentWorker)
            } else {
                weekForce.add(currentWorker)
            }
            previousWorker = currentWorker
            DailyOnCall(it.month, it.date, it.dayOfWeek, currentWorker, it.isHoliday, it.isWeekendAndHoliday)
        }
    }
}
