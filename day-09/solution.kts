@file:Include("../commons/io.kts")

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

fun findBasins(lowPoints: List<Pair<Int, Int>>, heights: List<List<Int>>): Int {
    val basins = mutableMapOf<Pair<Int, Int>, Int>()
    val visited = mutableSetOf<Pair<Int, Int>>()

    fun bfs(point: Pair<Int, Int>, lowPoint: Pair<Int, Int>) {
        val current = basins.getOrDefault(lowPoint, 0)
        if (point !in visited) {
            basins[lowPoint] = current + 1
        }
        visited.add(point)
        val left = Pair(point.first, point.second - 1)
        val right = Pair(point.first, point.second + 1)
        val top = Pair(point.first - 1, point.second)
        val bottom = Pair(point.first + 1, point.second)
        val neighbors = arrayOf(top, bottom, left, right).filter { it !in visited }
        for (neighbor in neighbors) {
            heights.getOrNull(neighbor.first)?.getOrNull(neighbor.second)?.let {
                if (it < 9) {
                    bfs(neighbor, lowPoint)
                }
            }
        }
    }
    lowPoints.forEach { bfs(it, it) }
    return basins.values.sortedDescending().take(3).reduce { a, b -> a * b }
}

fun main() {
    val lines: List<String> = readLines("day-09/input.txt")
    val heights = lines.map { it.split("").filter { it.isNotBlank() }.map { it.toInt() } }

    val lowPoints = findLowPoints(heights)
    val riskSum = lowPoints.map { heights[it.first][it.second] + 1 }.sum()
    println(riskSum)
    val top3Basins = findBasins(lowPoints, heights)
    println(top3Basins)
}
main()