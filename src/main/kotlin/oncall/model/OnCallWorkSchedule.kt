package oncall.model

class OnCallWorkSchedule {
    private val onCallWorkSchedule: MutableList<DailyOnCall> = mutableListOf()

    fun updateResult(initializedSchedule: List<DailyOnCall>) {
        onCallWorkSchedule.addAll(initializedSchedule)
    }

    fun getResult(): List<DailyOnCall> {
        return onCallWorkSchedule
    }
}
