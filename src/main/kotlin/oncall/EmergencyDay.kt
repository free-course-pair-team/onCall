package oncall

data class EmergencyDay(
    val workerName: String,
    val dayOfWeek: DayOfWeek,
    val day: Int,
    val isPublicHoliday: Boolean = false
)