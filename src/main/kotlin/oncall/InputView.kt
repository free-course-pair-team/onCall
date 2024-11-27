package oncall

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readMonthAndDayOfWeek(): Pair<Month, DayOfWeek> {
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ")
        val monthAndDayOfWeek = Console.readLine().split(",")
        require(monthAndDayOfWeek.size == 2) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        val (monthInput, dayOfWeekInput) = monthAndDayOfWeek
        val month = requireNotNull(monthInput.toIntOrNull()) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        require(month in 1..12) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        require(dayOfWeekInput in DayOfWeek.entries.map { it.text }) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        return Pair(Month.convertMonth(month), DayOfWeek.convertDayOfWeek(dayOfWeekInput))
    }

    fun readWeekDayWorkersName(): List<String> {
        val workersName = Console.readLine().split(",").map { it.trim() }
        require(workersName.distinct().size == workersName.size) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        require(workersName.size in 5..35) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        workersName.forEach { name ->
            require(name.length <= 5) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        }
        return workersName
    }

    fun readHolidayWorkersName(): List<String> {
        val workersName = Console.readLine().split(",").map { it.trim() }
        require(workersName.distinct().size == workersName.size) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        require(workersName.size in 5..35) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        workersName.forEach { name ->
            require(name.length <= 5) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        }
        return workersName
    }
}