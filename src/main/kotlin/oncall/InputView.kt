package oncall

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readMonthAndDayOfWeek(): List<String> {
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ")
        return Console.readLine().split(",")
    }

    fun readWeekDayWorkersName(): List<String> {
        print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
        val workersName = Console.readLine().split(",").map { it.trim() }
        return workersName
    }

    fun readHolidayWorkersName(): List<String> {
        print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
        val workersName = Console.readLine().split(",").map { it.trim() }
        return workersName
    }
}