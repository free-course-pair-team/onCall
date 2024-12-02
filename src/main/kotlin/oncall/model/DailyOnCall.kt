package oncall.model

data class DailyOnCall(
    val month: Int,
    val date: Int,
    val dayOfWeek: Week,
    val worker: Worker?,
    val isHoliday: Boolean, //(휴일) 표시를 넣기 위한 지표
    val isWeekendAndHoliday: Boolean //법정공휴일 근무자
)
