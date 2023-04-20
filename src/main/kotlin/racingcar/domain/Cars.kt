package racingcar.domain

class Cars private constructor(
    val cars: List<Car>,
) {
    val winners: List<Car>
        get() {
            val maxPosition = cars.maxBy { it.position }
            return cars.filter { it.isSameLocate(maxPosition) }
        }

    init {
        val notDuplicateNameSize = cars.map { it.name }
            .toHashSet()
            .size
        require(cars.size == notDuplicateNameSize) { "이름은 중복될 수 없습니다" }
    }

    fun moveAll(moveStrategy: MoveStrategy) {
        cars.forEach { it.move(moveStrategy.generate()) }
    }

    companion object {
        fun from(names: List<String>): Cars {
            val cars = names.map { Car.from(it) }
                .toList()
            return Cars(cars)
        }
    }
}
