package oncall

class OutputView {
    fun printResult(emergencyMonth: EmergencyMonth) {
        println()
        for (day in emergencyMonth.getEmergencyDays()) {
            if (day.isPublicHoliday) {
                println("${emergencyMonth.month}월 ${day.day}일 ${day.dayOfWeek.text}(휴일) ${day.worker.name}")
                continue
            }
            println("${emergencyMonth.month}월 ${day.day}일 ${day.dayOfWeek.text} ${day.worker.name}")
        }
    }
}