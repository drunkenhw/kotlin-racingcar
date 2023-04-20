package racingcar

import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.TryCount
import racingcar.view.printCarsPosition
import racingcar.view.printErrorMessage
import racingcar.view.printWinners
import racingcar.view.readNames
import racingcar.view.readTryCount

fun main() {
    val cars = createCars()
    val tryCount = decideTotalRound()
    val racingGame = RacingGame(cars, tryCount)

    while (racingGame.isPlayable()) {
        racingGame.playOneRound()
        printCarsPosition(cars.cars)
    }

    printWinners(racingGame.findWinners())
}

private fun createCars(): Cars {
    return runCatching {
        Cars.from(readNames())
    }.onFailure {
        when (it) {
            is IllegalArgumentException -> printErrorMessage(it.message ?: "오류가 발생했습니다.")
            else -> throw it
        }
    }.getOrElse {
        createCars()
    }
}

private fun decideTotalRound(): TryCount {
    return runCatching {
        return TryCount(readTryCount())
    }.onFailure {
        when (it) {
            is IllegalArgumentException -> printErrorMessage(it.message ?: "오류가 발생했습니다.")
            else -> throw it
        }
    }.getOrElse {
        decideTotalRound()
    }
}
