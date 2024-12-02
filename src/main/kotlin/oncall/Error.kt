package oncall


enum class Error(private val message: String) {
    INPUT_FORMAT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    MONTH_RANGE("비상 근무 월은 1에서 12의 정수를 입력해 주세요."),
    DAY_OF_WEEK_RANGE("요일은 월 화 수 목 금 토 일 만 입력해 주세요"),
    DUPLICATE_WORKER_NAME("닉네임에 중복이 있습니다. 다시 입력해 주세요."),
    WORKER_RANGE("비상 근무자는 최소 5명 최대 35명까지만 입력해 주세요."),
    WORKER_NAME_LENGTH("비상 근무자 닉네임은 1에서 5자리를 입력해 주세요.");

    fun getMessage() = "[ERROR] " + this.message
}