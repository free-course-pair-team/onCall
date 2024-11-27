package oncall.model

enum class Holiday(val month: Int, val date: Int) {
    신정(1, 1), 삼일절(3, 1), 어린이날(5, 5), 현충일(6, 6), 광복절(8, 15), 개천절(10, 3), 한글날(10, 9), 성탄절(12, 25)
}
