private fun part1(input: List<String>): Int {
    return input.size
}

private fun part2(input: List<String>): Int {
    return input.size
}


fun main() {
    val testInput = readInput("day1-test")
    check(part1(testInput) == 1)

    val input = readInput("day1")
    println(part1(input))
    println(part2(input))
}
