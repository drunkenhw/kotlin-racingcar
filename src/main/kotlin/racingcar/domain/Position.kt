package racingcar.domain

data class Position(
    val value: Int = DEFAULT_VALUE,
) : Comparable<Position> {
    init {
        require(value >= MINIMUM_VALUE) { "위치 값은 ${MINIMUM_VALUE}보다 커야합니다" }
    }

    fun increase(): Position {
        return Position(value + INCREMENT)
    }

    override fun compareTo(other: Position): Int = value.compareTo(other.value)

    companion object {
        private const val DEFAULT_VALUE = 0
        private const val INCREMENT = 1
        private const val MINIMUM_VALUE = 0
    }
}
