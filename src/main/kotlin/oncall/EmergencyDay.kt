package oncall

data class EmergencyDay(
    val worker: Worker,
    val dayOfWeek: DayOfWeek,
    val day: Int,
    val isPublicHoliday: Boolean = false
)