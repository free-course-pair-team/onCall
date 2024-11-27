package oncall

class OutputView {
    fun printResult(emergencyMonth: EmergencyMonth) {
        println()
        for (day in emergencyMonth.emergencyDays) {
            if (day.isPublicHoliday) {
                println("${emergencyMonth.month}월 ${day.day}일 ${day.dayOfWeek.text}(휴일) ${day.workerName}")
                continue
            }
            println("${emergencyMonth.month}월 ${day.day}일 ${day.dayOfWeek.text} ${day.workerName}")
        }
    }
}