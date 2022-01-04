//INCLUDE ../commons/io.kt

import aoc.commons.readLines

fun main () {
    val line = readLines("day-07/input.txt")[0]
    val crabPositions = line.split(",").map { it.toInt() }.sorted()
    val finalPos = crabPositions.get(crabPositions.size/ 2)

    val fuelUsed1 = crabPositions.map { Math.abs(it - finalPos) }.sum()
    println(fuelUsed1)

    val meanPos = crabPositions.sum().toDouble() / crabPositions.size
    val floorMean = Math.floor(meanPos)
    val ceilMean = Math.ceil(meanPos)

    val fuelUsedFloor = crabPositions.sumOf { 
        val delta = Math.abs(it - floorMean).toLong()
        delta * (delta + 1) / 2
    }

    val fuelUsedCeil = crabPositions.sumOf { 
        val delta = Math.abs(it - ceilMean).toLong()
        delta * (delta + 1) / 2
    }

    println(Math.min(fuelUsedFloor.toLong(), fuelUsedCeil.toLong()))
}