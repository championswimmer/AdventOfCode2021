//INCLUDE ../commons/io.kt

import aoc.commons.readLines


fun main() {
    val lines = readLines("day-01/input.txt")
    val nums = lines.map { it.toInt() }
    val threesums = Array(nums.size - 2) { 0 }
    for (i in 0 until threesums.size) {
        threesums[i] = nums[i] + nums[i + 1] + nums[i + 2]
    }
    var count = 0
    for (i in 1 until threesums.size) {
        if (threesums[i] > threesums[i - 1]) {
            count++
        }
    }
    println(count)
}