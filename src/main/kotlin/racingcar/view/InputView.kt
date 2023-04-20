package racingcar.view

fun readNames(): List<String> {
    println("이름을 입력해주세요")
    val input = readln()
    return input.split(",")
        .map { it.trim() }
}

fun readTryCount(): Int {
    println("시도 횟수를 입력해주세요")
    val input = readln()
    require(isNumber(input)) { "숫자만 입력 가능합니다" }
    return input.toInt()
}

fun isNumber(input: String): Boolean {
    return input.chars()
        .allMatch { Character.isDigit(it) }
}
