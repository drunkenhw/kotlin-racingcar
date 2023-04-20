package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NameTest : StringSpec({

    "이름이 0자 또는 6자 이상이면 예외를 발생시킨다" {
        listOf("", "123456")
            .forEach { input: String ->
                shouldThrow<IllegalArgumentException> { Name(input) }
                    .message shouldBe "이름은 5자 이하만 가능합니다"
            }
    }
})
