package oncall.model

class OnCallWorkSchedule {
    private val onCallWorkSchedule: MutableList<DailyOnCall> = mutableListOf()

    fun initializeResult(initializedSchedule: List<DailyOnCall>) {
        onCallWorkSchedule.addAll(initializedSchedule)
    }

    fun updateResult() {}
    fun getResult(): List<DailyOnCall> {
        return onCallWorkSchedule
    }
}
