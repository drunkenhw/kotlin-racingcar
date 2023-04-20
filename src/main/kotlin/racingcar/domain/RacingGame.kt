package racingcar.domain

class RacingGame(
    private val cars: Cars,
    private var tryCount: TryCount,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
) {

    fun playOneRound() {
        cars.moveAll(moveStrategy)
        tryCount = tryCount.decrease()
    }

    fun findWinners(): List<Car> {
        return cars.winners
    }

    fun isPlayable(): Boolean {
        return tryCount.isGreaterThanZero()
    }
}
