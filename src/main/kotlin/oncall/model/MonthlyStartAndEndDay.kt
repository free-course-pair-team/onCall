package oncall.model

enum class MonthlyStartAndEndDay(val start: Int, val end: Int) {
    JAN(1, 31), FEB(1, 28), MAR(1, 31), APR(1, 30), MAY(1, 31), JUN(1, 30), JUL(1, 31), AUG(1, 31), SEP(1, 30), OCT(
        1,
        31
    ),
    NOB(1, 30), DEC(1, 31)
}
