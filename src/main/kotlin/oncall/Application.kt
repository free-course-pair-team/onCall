package oncall

import oncall.controller.OnCallController
import oncall.domain.OnCallMonthGenerator
import oncall.domain.OnCallWorkerGenerator
import oncall.util.Validator
import oncall.view.InputView
import oncall.view.OutputView

fun main() {
    val inputView = InputView()
    val valildator = Validator()
    val onCallMonthGenerator = OnCallMonthGenerator()
    val onCallWorkerGenerator = OnCallWorkerGenerator()
    val outputView = OutputView()
    val controller = OnCallController(inputView, valildator, onCallMonthGenerator, onCallWorkerGenerator, outputView)
    controller.run()
}
