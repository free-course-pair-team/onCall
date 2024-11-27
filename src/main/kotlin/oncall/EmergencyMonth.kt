package oncall

class EmergencyMonth(val month: Int, emergencyDays: List<EmergencyDay>) {
    private val emergencyDays = emergencyDays.toMutableList()

    init {
        initEmergencyDays()
    }

    private fun initEmergencyDays() {
        var currentWorkerWorker = emergencyDays.first().worker
        for (emergencyDayIndex in 1..<emergencyDays.size) {
            val emergencyDay = emergencyDays[emergencyDayIndex]
            if (currentWorkerWorker.name == emergencyDay.worker.name) {
                val switchWorkerNameIndex = emergencyDays.subList(emergencyDayIndex + 1, emergencyDays.size)
                    .indexOfFirst { it.worker.isHoliday == emergencyDay.worker.isHoliday } + emergencyDayIndex + 1
                if (switchWorkerNameIndex == -1) {
                    currentWorkerWorker = emergencyDay.worker
                    continue
                }
                val switchDay = emergencyDays[switchWorkerNameIndex]
                currentWorkerWorker = switchDay.worker
                emergencyDays[emergencyDayIndex] = emergencyDays[emergencyDayIndex].copy(worker = switchDay.worker)
                emergencyDays[switchWorkerNameIndex] =
                    emergencyDays[switchWorkerNameIndex].copy(worker = emergencyDay.worker)
            } else {
                currentWorkerWorker = emergencyDay.worker
            }
        }
    }

    fun getEmergencyDays() = emergencyDays.toList()
}