package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PositionTest : StringSpec({

    "position의 값이 증가한다" {
        val position = Position()

        val expectPosition = position.increase()

        expectPosition.value shouldBe 1
    }

    "position의 값이 높은 것을 반환한다" {
        val one = Position(1)
        val zero = Position()

        val bigPosition = one.compareTo(zero)

        bigPosition shouldBe 1
    }
})
