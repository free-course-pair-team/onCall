package oncall.validator

class InputValidator {
    fun validateSeparator(input: List<String>) {
        require(input.size == 2) { WRONG_INPUT }
    }

    fun validateMonth(month: Int) {
        require(month in listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)) { WRONG_INPUT }
    }

    fun validateDayOfWeek(day: String) {
        require(day in listOf("일", "월", "화", "수", "목", "금", "토")) { WRONG_INPUT }
    }

    fun validateDuplicatedWorker(workers: List<String>) {
        val setOfWorkers = workers.toSet()
        require(setOfWorkers.size == workers.size) { "[ERROR] 이름 중복 금지" }
    }

    fun validateWorkerNameLength(workers: List<String>) {
        workers.forEach { worker ->
            require(worker.length <= 5) { "[ERROR] 이름 5자 이내로 작성해주세요" }
        }
    }

    fun validateWorkersNumber(workers: List<String>) {
        require(workers.size <= 35) { "[ERROR] 35명 미만으로 작성해주세요" }
    }

    companion object {
        const val WRONG_INPUT = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
    }
}
