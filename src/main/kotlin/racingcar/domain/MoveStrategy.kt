package racingcar.domain

fun interface MoveStrategy {
    fun generate(): Action
}
