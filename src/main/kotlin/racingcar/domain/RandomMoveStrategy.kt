package racingcar.domain

class RandomMoveStrategy : MoveStrategy {
    override fun generate(): Action {
        val randomNumber = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()
        if (randomNumber >= THRESHOLD) {
            return Action.MOVE
        }
        return Action.STAY
    }

    companion object {
        private const val THRESHOLD = 4
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
    }
}
