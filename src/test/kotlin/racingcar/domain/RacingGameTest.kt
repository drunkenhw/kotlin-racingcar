package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({
    "우승자를 반환한다" {
        val racingGame = RacingGame(Cars.from(listOf("하티", "박스터")), TryCount(3)) { Action.MOVE }

        racingGame.playOneRound()

        racingGame.findWinners().map { it.name } shouldContainAll listOf(Name("하티"), Name("박스터"))
    }

    "게임을 횟수만큼 진행하면 false를 반환한다" {
        val racingGame = RacingGame(Cars.from(listOf("하티", "박스터")), TryCount(3)) { Action.MOVE }

        racingGame.playOneRound()
        racingGame.playOneRound()
        racingGame.playOneRound()

        racingGame.isPlayable() shouldBe false
    }

    "게임을 횟수만큼 진행하지 않으면 true를 반환한다" {
        val racingGame = RacingGame(Cars.from(listOf("하티", "박스터")), TryCount(3)) { Action.MOVE }

        racingGame.playOneRound()

        racingGame.isPlayable() shouldBe true
    }
})
