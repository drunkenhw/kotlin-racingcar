package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "자동차는 주어진 액션에 따라 움직일 수 있다" {
        listOf(
            Action.MOVE to 1,
            Action.STAY to 0,
        ).forAll { (action: Action, expect: Int) ->
            val car = Car.from("박스터")

            car.move(action)

            car.position.value shouldBe expect
        }
    }
})
