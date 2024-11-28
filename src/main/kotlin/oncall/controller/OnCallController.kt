package oncall.controller

import oncall.domain.OnCallMonthGenerator
import oncall.model.OnCallWorkSchedule
import oncall.model.Week
import oncall.util.Validator
import oncall.view.InputView

class OnCallController(
    private val inputView: InputView,
    private val validator: Validator,
    private val onCallMonthGenerator: OnCallMonthGenerator,
) {

    private val onCallWorkSchedule = OnCallWorkSchedule()

    fun run() {
        val (month ,week) = inputMonthAndStartDayOfWeek()
        onCallWorkSchedule.initializeResult(onCallMonthGenerator.generateOnCallMonth(month, week))


    }


    private fun inputMonthAndStartDayOfWeek(): Pair<Int, Week> {
        val monthAndStartDayOfWeek = inputView.inputMonthAndStartDayOfWeek()
        return validator.validateInputMonthAndStartDayOfWeek(monthAndStartDayOfWeek)
    }

    private fun inputWeekdaysWorkforce() {
        inputView.inputWeekdaysWorkforce()
    }

    private fun inputWeekendsWorkforce() {
        inputView.inputWeekendsWorkforce()
    }
}