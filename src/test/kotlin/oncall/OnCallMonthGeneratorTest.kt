package oncall

import camp.nextstep.edu.missionutils.test.NsTest
import oncall.domain.OnCallMonthGenerator
import oncall.model.Week
import org.junit.jupiter.api.Test

class OnCallMonthGeneratorTest : NsTest() {
    override fun runMain() {
        TODO("Not yet implemented")
    }

    @Test
    fun test_genrate_month() {
        val onCallMonthGenerator = OnCallMonthGenerator()
        println(onCallMonthGenerator.generateOnCallMonth(5, Week.WED))
    }
}
