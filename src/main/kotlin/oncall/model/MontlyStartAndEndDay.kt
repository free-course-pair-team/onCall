package oncall.model

enum class MontlyStartAndEndDay(val month: Int, val start: Int, val end: Int) {
    JAN(1, 1, 31), FAB(2, 1, 28), MAR(3, 1, 31), APR(4, 1, 30), MAY(5, 1, 31), JUN(6, 1, 30), JUL(7, 1, 31), AUG(
        8,
        1,
        31
    ),
    SEP(9, 1, 30), OCT(10, 1, 31), NOB(11, 1, 30), DEC(12, 1, 31)
}
