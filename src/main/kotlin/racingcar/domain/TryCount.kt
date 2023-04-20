package racingcar.domain

data class TryCount(
    val value: Int
) {
    init {
        require(value > -1) { "시도 횟수는 음수일 수 없습니다" }
    }

    fun decrease(): TryCount {
        return TryCount(value - 1)
    }

    fun isGreaterThanZero(): Boolean {
        return value > 0
    }
}
