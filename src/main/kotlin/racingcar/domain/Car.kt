package racingcar.domain

class Car private constructor(
    val name: Name,
) {
    var position: Position = Position()
        private set

    fun move(action: Action) {
        position = when (action) {
            Action.MOVE -> position.increase()
            else -> position.copy()
        }
    }

    fun isSameLocate(other: Car): Boolean {
        return this.position == other.position
    }

    companion object {
        fun from(name: String): Car {
            return Car(Name(name))
        }
    }
}
