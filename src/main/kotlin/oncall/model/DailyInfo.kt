package oncall.model

data class DailyInfo(
    val month: Int,
    val day: Int,
    val dayOfWeek: DayOfWeek,
    val worker: String?,
    val isHoliday: Boolean
)
