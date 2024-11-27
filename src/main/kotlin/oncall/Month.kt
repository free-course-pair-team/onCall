package oncall

enum class Month(val month: Int, val days: List<Int>) {
    JANUARY(1, (1..31).toList()),
    FEBRUARY(2, (1..28).toList()),
    MARCH(3, (1..31).toList()),
    APRIL(4, (1..30).toList()),
    MAY(5, (1..31).toList()),
    JUNE(6, (1..30).toList()),
    JULY(7, (1..31).toList()),
    AUGUST(8, (1..31).toList()),
    SEPTEMBER(9, (1..30).toList()),
    OCTOBER(10, (1..31).toList()),
    NOVEMBER(11, (1..30).toList()),
    DECEMBER(12, (1..31).toList())
}