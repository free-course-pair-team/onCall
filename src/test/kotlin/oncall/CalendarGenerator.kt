package oncall

import camp.nextstep.edu.missionutils.test.NsTest
import oncall.domain.CalendarGenerator
import oncall.model.DayOfWeek
import org.junit.jupiter.api.Test

class CalendarGenerator : NsTest() {
    override fun runMain() {
        TODO("Not yet implemented")
    }

    @Test
    fun test_generate_calendar() {
        val calendarGenerator = CalendarGenerator()
        val result = calendarGenerator.generateCalendar(5, DayOfWeek.월)
        println(result)
    }
}
