package oncall.model

class OnCallResult {
    private val onCallResult: MutableList<DailyInfo> = mutableListOf()

    fun initializeOnCallResult(initializedOnCallResult: List<DailyInfo>) {
        onCallResult.addAll(initializedOnCallResult)
    }

    fun updateOnCallResult() {}
    fun getOnCallResult(): List<DailyInfo> {
        return onCallResult
    }
}
