package oncall.util

import oncall.model.Week

class Validator {

    fun validateInputMonthAndStartDayOfWeek(input: String): Pair<Int, Week> {
        val i = input.split(",")
        val month = validateInputMonth(i[0])
        val week = validateInputStartDayOfWeek(i[1])
        return month to week
    }

    private fun validateInputMonth(input: String): Int {
        val month = requireNotNull(input.toIntOrNull()) {
            "월은 숫자만 입력이 가능합니다."
        }
        require(month in 1..12) {
            "1~12까지의 월 입력이 가능합니다."
        }
        return month
    }

    private fun validateInputStartDayOfWeek(input: String) =
        requireNotNull(Week.entries.find { it.dayName == input }) {
            "일, 월, 화, 수, 목, 금, 토 요일 입력이 가능합니다."
        }

}