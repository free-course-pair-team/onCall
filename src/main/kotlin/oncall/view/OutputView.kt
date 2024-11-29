package oncall.view

import oncall.model.OnCallWorkSchedule

class OutputView {
    fun printOnCallWorkSchedule(onCallWorkerSchedule: OnCallWorkSchedule) {
        onCallWorkerSchedule.getResult().forEach {
            //5월 5일 금(휴일) 루루
            val holidayMark = if (it.isHoliday) "(휴일)" else ""
            println("${it.month}월 ${it.date}일 ${it.dayOfWeek.dayName}${holidayMark} ${it.worker}")
        }
    }
}
