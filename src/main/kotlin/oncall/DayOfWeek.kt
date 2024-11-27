package oncall

enum class DayOfWeek(val text: String, val isHoliday: Boolean = false) {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토", true),
    SUNDAY("일", true);

    fun nextDayOfWeek(): DayOfWeek {
        val nextDayOfWeekIndex = (DayOfWeek.entries.indexOf(this) + 1) % DayOfWeek.entries.size
        return DayOfWeek.entries[nextDayOfWeekIndex]
    }

    companion object {
        fun convertDayOfWeek(dayOfWeekInput: String): DayOfWeek {
            val dayOfWeekIndex = DayOfWeek.entries.indexOfFirst { it.text == dayOfWeekInput }
            return DayOfWeek.entries[dayOfWeekIndex]
        }
    }
}