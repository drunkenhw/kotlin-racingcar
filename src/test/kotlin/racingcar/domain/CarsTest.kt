package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({

    "중복된 이름이 있으면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> { Cars.from(listOf("박스터", "박스터")) }
            .message shouldBe "이름은 중복될 수 없습니다"
    }

    "자동차를 전진시킨다" {
        val cars = Cars.from(listOf("하티", "박스터"))

        cars.moveAll { Action.MOVE }

        cars.cars.map { it.position } shouldContainExactly listOf(Position(1), Position(1))
    }
})
