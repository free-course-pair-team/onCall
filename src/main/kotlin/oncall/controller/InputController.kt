package oncall.controller

import camp.nextstep.edu.missionutils.Console
import oncall.validator.InputValidator

class InputController(val inputValidator: InputValidator) {
    fun getMonthAndStartDayOfWeek(): Pair<Int, String> {
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요>")
        val input = Console.readLine().replace(" ", "").split(",")
        inputValidator.validateSeparator(input)
        inputValidator.validateMonth(input.get(0).toInt())
        inputValidator.validateDayOfWeek(input.get(1))
        return Pair(input.get(0).toInt(), input.get(1))
    }

    fun getWorkers(): Pair<List<String>, List<String>> {
        while (true) {
            try {
                print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>")
                val weekWorker = Console.readLine().replace(" ", "").split(",")
                inputValidator.validateWorkersNumber(weekWorker)
                inputValidator.validateWorkerNameLength(weekWorker)
                inputValidator.validateDuplicatedWorker(weekWorker)
                print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>")
                val weekendHolidayWorker = Console.readLine().replace(" ", "").split(",")
                inputValidator.validateWorkersNumber(weekendHolidayWorker)
                inputValidator.validateWorkerNameLength(weekendHolidayWorker)
                inputValidator.validateDuplicatedWorker(weekendHolidayWorker)
                return Pair(weekWorker, weekendHolidayWorker)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

}
