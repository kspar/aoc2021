


private fun part1(input: List<String>): Int {
    return input.map { it.toInt() }
        .zipWithNext()
        .count { it.second > it.first }
}

private fun part2(input: List<String>): Int {
    return input.map { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .zipWithNext()
        .count { it.second > it.first }
}


fun main() {
    val testInput = readInput("day1-test")
//    debug { part1(testInput) }
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("day1")
    println(part1(input))
    println(part2(input))
}
