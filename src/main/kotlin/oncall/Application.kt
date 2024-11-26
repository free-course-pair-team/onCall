package oncall

import oncall.controller.Controller
import oncall.controller.InputController
import oncall.domain.CalendarGenerator
import oncall.validator.InputValidator

fun main() {
    val inputValidator = InputValidator()
    val inputController = InputController(inputValidator)
    val calendarGenerator = CalendarGenerator()
    val controller = Controller(inputController, calendarGenerator)
    controller.run()
}
