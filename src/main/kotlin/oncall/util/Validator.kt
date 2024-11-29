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
        require(5 <= workforce.size && workforce.size <= 35) { "[ERROR] 근무자는 5명에서 35명으로 작성해야합니다." }
        workforce.forEach { name ->
            validateInputWorkforceMaxStringLength(name)
        }
        validateIdenticalName(workforce)
        return workforce
    }


    private fun validateInputMonth(input: String): Int {
        val month = requireNotNull(input.toIntOrNull()) {
            "[ERROR] 월은 숫자만 입력이 가능합니다."
        }
        require(month in 1..12) {
            "[ERROR] 1~12까지의 월 입력이 가능합니다."
        }
        return month
    }

    private fun validateInputStartDayOfWeek(input: String) =
        requireNotNull(Week.entries.find { it.dayName == input }) {
            "[ERROR] 일, 월, 화, 수, 목, 금, 토 요일 입력이 가능합니다."
        }

    private fun validateInputWorkforceMaxStringLength(input: String) {
        require(input.length <= 5) {
            "[ERROR] 이름은 최대 5자리까지 가능합니다."
        }
    }

    private fun validateIdenticalName(workForce: List<String>) {
        val set = workForce.toSet()
        require(set.size == workForce.size) { "[ERROR] 중복된 닉네임은 불가합니다." }
    }

    //모든 구성원의 근무가 평일, 휴일 모두 들어가 있는지 확인
    fun validateWeekAndWeekendScehdule(weekWorkforce: Set<String>, weekendWorkforce: Set<String>) {
        require(weekWorkforce == weekendWorkforce) { "[ERROR] 모든 근무자는 평일, 휴일 모두 근무해야합니다" }
    }

}
