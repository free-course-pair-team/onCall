package oncall.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputMonthAndStartDayOfWeek(): String {
        println(INPUT_MONTH_AND_START_DAY_OF_WEEK)
        return Console.readLine()
    }

//    fun inputWeekdaysWorkforce(): String {
//        println()
//        return Console.readLine()
//    }

    companion object {
        const val INPUT_MONTH_AND_START_DAY_OF_WEEK = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
    }
}