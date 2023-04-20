package racingcar.view

import racingcar.domain.Car

private const val POSITION_BAR = "-"

fun printErrorMessage(message: String) {
    println(message)
}

fun printCarsPosition(cars: List<Car>) {
    cars.forEach { println("${it.name.value}: ${POSITION_BAR.repeat(it.position.value)}") }
}

fun printWinners(winners: List<Car>) {
    val winnerNames = winners.map { it.name.value }
    println("우승자는 ${winnerNames.joinToString(", ")} 입니다")
}
