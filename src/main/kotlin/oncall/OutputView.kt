package oncall

class OutputView {
    fun printResult(emergencyMonth: EmergencyMonth) {
        println()
        emergencyMonth.emergencyDays.forEach { day ->
            println("${emergencyMonth.month}월 ${day.day}일 ${day.dayOfWeek.text} ${day.workerName}")
        }
    }
}