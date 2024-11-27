package oncall

data class EmergencyMonth(val month: Int, private val emergencyDays: List<EmergencyDay>) {
    fun getEmergencyDays() = emergencyDays.toList()
}