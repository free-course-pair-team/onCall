package oncall.controller

import oncall.domain.OnCallMonthGenerator
import oncall.domain.OnCallWorkerGenerator
import oncall.model.OnCallWorkSchedule
import oncall.model.Week
import oncall.util.Validator
import oncall.util.retryInput
import oncall.view.InputView
import oncall.view.OutputView

class OnCallController(
    private val inputView: InputView,
    private val validator: Validator,
    private val onCallMonthGenerator: OnCallMonthGenerator,
    private val onCallWorkerGenerator: OnCallWorkerGenerator,
    private val outputView: OutputView
) {

    private val onCallWorkSchedule = OnCallWorkSchedule()

    fun run() {
        val (month, week) = inputMonthAndStartDayOfWeek()
        val initializedOnCallMonth = onCallMonthGenerator.generateOnCallMonth(month, week)
        val (weekForce, weekendForce) = inputWeekdaysWorkforce()
        val result = onCallWorkerGenerator.generateOnCallWorker(
            initializedOnCallMonth.toMutableList(),
            weekForce.toMutableList(),
            weekendForce.toMutableList()
        )
        onCallWorkSchedule.updateResult(result)
        outputView.printOnCallWorkSchedule(onCallWorkSchedule)
    }

    private fun inputMonthAndStartDayOfWeek(): Pair<Int, Week> {
        return retryInput {
            val monthAndStartDayOfWeek = inputView.inputMonthAndStartDayOfWeek()
            return@retryInput validator.validateInputMonthAndStartDayOfWeek(monthAndStartDayOfWeek)
        }
    }

    private fun inputWeekdaysWorkforce(): Pair<List<String>, List<String>> {
        return retryInput {
            val weekWorkforce = inputView.inputWeekdaysWorkforce()
            val weekendWorkforce = inputView.inputWeekendsWorkforce()
            val validatedWeekWorkForce = validator.validateInputWorkforce(weekWorkforce)
            val validatedWeekendWorkForce = validator.validateInputWorkforce(weekendWorkforce)
            validator.validateWeekAndWeekendScehdule(
                validatedWeekWorkForce.toSet(),
                validatedWeekendWorkForce.toSet()
            )
            return@retryInput Pair(validatedWeekWorkForce, validatedWeekendWorkForce)
        }
    }
}
