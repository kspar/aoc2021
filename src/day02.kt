


private fun part1(input: List<String>): Int {
    return input.groupBy {
        it.split(" ")[0]
    }.map {
        it.key to it.value.sumOf {
            it.split(" ").last().toInt()
        }
    }.toMap().let {
        ((it["down"] ?: 0) - (it["up"] ?: 0)) * (it["forward"] ?: 0)
    }
}

private fun part2(input: List<String>): Int {
    return input.map {
        it.split(" ").let {
            it.first() to it.last().toInt()
        }
    }.fold(Triple(0, 0, 0)) { acc, instruction: Pair<String, Int> ->
        val currentAim = acc.first
        val currentPos = acc.second
        val currentDepth = acc.third

        val cmd = instruction.first
        val value = instruction.second

        when(cmd) {
            "down" -> Triple(currentAim + value, currentPos, currentDepth)
            "up" -> Triple(currentAim - value, currentPos, currentDepth)
            "forward" -> Triple(currentAim, currentPos + value, currentDepth + currentAim * value)
            else -> throw IllegalStateException("cmd = $cmd")
        }
    }.let {
        it.second * it.third
    }
}


fun main() {
    val testInput = readInput("day2-test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("day2")
    println(part1(input))
    println(part2(input))
}
