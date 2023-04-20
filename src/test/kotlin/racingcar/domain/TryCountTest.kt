package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TryCountTest : StringSpec({

    "시도 횟수가 1씩 감소한다" {
        val tryCount = TryCount(10)

        tryCount.decrease() shouldBe TryCount(9)
    }

    "시도 횟수가 0보다 크면 true를 반환한다" {
        val tryCount = TryCount(10)

        tryCount.isGreaterThanZero() shouldBe true
    }

    "시도 횟수가 음수면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> { TryCount(-1) }
            .message shouldBe "시도 횟수는 음수일 수 없습니다"
    }
})
