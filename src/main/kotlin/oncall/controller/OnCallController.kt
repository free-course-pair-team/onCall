package oncall.controller

import oncall.domain.OnCallMonthGenerator
import oncall.util.Validator
import oncall.view.InputView

class OnCallController(
    private val inputView: InputView,
    private val validator: Validator,
    private val onCallMonthGenerator: OnCallMonthGenerator,
) {


    fun inputMonthAndStartDayOfWeek() {
        val monthAndStartDayOfWeek = inputView.inputMonthAndStartDayOfWeek()
        val (month ,week) = validator.validateInputMonthAndStartDayOfWeek(monthAndStartDayOfWeek)
        onCallMonthGenerator.generateOnCallMonth(month, week)

    }
}