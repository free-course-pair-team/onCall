package oncall

import oncall.util.Validator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    @ParameterizedTest()
    @ValueSource(
        strings = ["가, 월", "5, 지", "13, 수"],
    )
    @DisplayName("월, 시작 요일 입력 오류 처리")
    fun inputMonthAndStartWeekOfDateThrowException(input: String) {
        assertThrows<IllegalArgumentException> {
            val validator = Validator()
            validator.validateInputMonthAndStartDayOfWeek(input)
        }
    }
}