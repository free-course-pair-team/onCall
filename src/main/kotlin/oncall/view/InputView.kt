package oncall.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputMonthAndStartDayOfWeek(): String {
        println(INPUT_MONTH_AND_START_DAY_OF_WEEK)
        return Console.readLine()
    }

    fun inputWeekdaysWorkforce(): String {
        println(INPUT_WEEKDAYS_WORKFORCE)
        return Console.readLine()
    }

    fun inputWeekendsWorkforce(): String {
        println(INPUT_WEEKENDS_WORKFORCE)
        return Console.readLine()
    }

    companion object {
        const val INPUT_MONTH_AND_START_DAY_OF_WEEK = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
        const val INPUT_WEEKDAYS_WORKFORCE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
        const val INPUT_WEEKENDS_WORKFORCE = "주말 비상 근무 순번대로 사원 닉네임을 입력하세요> "
    }
}