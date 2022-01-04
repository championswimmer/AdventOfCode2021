//INCLUDE ../commons/io.kt

import aoc.commons.readLines

fun findLowPoints(heights: List<List<Int>>): List<Pair<Int, Int>> {
    val lowPoints: MutableList<Pair<Int, Int>> = mutableListOf()
    for (i in 0 until heights.size) {
        for (j in 0 until heights[0].size) {
            val current = heights[i][j]
            val left: Int? = heights[i].getOrNull(j - 1)
            val right: Int? = heights[i].getOrNull(j + 1)
            val top: Int? = heights.getOrNull(i - 1)?.get(j)
            val bottom: Int? = heights.getOrNull(i + 1)?.get(j)
            val lowerSides = arrayOf(top, bottom, left, right).filterNotNull().filter { it <= current }
            if (lowerSides.isEmpty()) {
                lowPoints.add(Pair(i, j))
            }
        }
    }
    return lowPoints
}

fun findBasins(lowPoints: List<Pair<Int, Int>>) {
}

fun main() {
    val lines: List<String> = readLines("day-09/input.txt")
    val heights = lines.map { it.split("").filter { it.isNotBlank() }.map { it.toInt() } }

    val lowPoints = findLowPoints(heights)
    val riskSum = lowPoints.map { heights[it.first][it.second] + 1 }.sum()
    println(riskSum)
    findBasins(lowPoints)
}
