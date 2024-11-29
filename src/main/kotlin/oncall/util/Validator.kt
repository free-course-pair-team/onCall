package oncall.util

import oncall.model.Week

class Validator {

    fun validateInputMonthAndStartDayOfWeek(input: String): Pair<Int, Week> {
        val i = input.replace(" ", "").split(",")
        val month = validateInputMonth(i[0])
        val week = validateInputStartDayOfWeek(i[1])
        return month to week
    }

    fun validateInputWorkforce(input: String): List<String> {
        val workforce = input.replace(" ", "").split(",")
        require(workforce.size in 5..35) { ERROR_MSG_OUT_OF_RANGE_IN_WORKERS }
        workforce.forEach { name ->
            validateInputWorkforceMaxStringLength(name)
        }
        validateIdenticalName(workforce)
        return workforce
    }


    private fun validateInputMonth(input: String): Int {
        val month = requireNotNull(input.toIntOrNull()) {
            ERROR_MSG_CAN_INPUT_ONLY_NUMBER
        }
        require(month in 1..12) {
            ERROR_MSG_OUT_OF_RANGE_IN_MONTH
        }
        return month
    }

    private fun validateInputStartDayOfWeek(input: String) =
        requireNotNull(Week.entries.find { it.dayName == input }) {
            ERROR_MSG_OUT_OF_RANGE_IN_WEEK_OF_DAY
        }

    private fun validateInputWorkforceMaxStringLength(input: String) {
        require(input.length <= 5) {
            ERROR_MSG_CAN_INPUT_FIVE_LENGTH
        }
    }

    private fun validateIdenticalName(workForce: List<String>) {
        val set = workForce.toSet()
        require(set.size == workForce.size) { ERROR_MSG_CANNOT_INPUT_DUPLICATE_NAME }
    }

    //모든 구성원의 근무가 평일, 휴일 모두 들어가 있는지 확인
    fun validateWeekAndWeekendScehdule(weekWorkforce: Set<String>, weekendWorkforce: Set<String>) {
        require(weekWorkforce == weekendWorkforce) { ERROR_MSG_NOT_IDENTICAL_WORKERS_SET }
    }
    companion object {
        const val ERROR_MSG_OUT_OF_RANGE_IN_WORKERS = "[ERROR] 근무자는 5명에서 35명으로 작성해야합니다."
        const val ERROR_MSG_CAN_INPUT_ONLY_NUMBER = "[ERROR] 월은 숫자만 입력이 가능합니다."
        const val ERROR_MSG_OUT_OF_RANGE_IN_MONTH= "[ERROR] 1~12까지의 월 입력이 가능합니다."
        const val ERROR_MSG_OUT_OF_RANGE_IN_WEEK_OF_DAY = "[ERROR] 일, 월, 화, 수, 목, 금, 토 요일 입력이 가능합니다."
        const val ERROR_MSG_CAN_INPUT_FIVE_LENGTH = "[ERROR] 이름은 최대 5자리까지 가능합니다."
        const val ERROR_MSG_CANNOT_INPUT_DUPLICATE_NAME = "[ERROR] 중복된 닉네임은 불가합니다."
        const val ERROR_MSG_NOT_IDENTICAL_WORKERS_SET = "[ERROR] 모든 근무자는 평일, 휴일 모두 근무해야합니다"



    }
}
