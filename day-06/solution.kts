@file:Include("../commons/io.kts")
import java.math.BigInteger

fun main() {
    val line: String = readLines("day-06/input.txt")[0]
    // val line = "3,4,3,1,2"
    val fishAges = line.split(",").map { it.toInt() }
    val fishAgeBuckets = Array(9) { 0L }

    fishAges.forEach { age -> fishAgeBuckets[age]++ }

    for (i in 0..255) {
        val zeroAgeFish = fishAgeBuckets[0]
        fishAgeBuckets[0] = fishAgeBuckets[1]
        fishAgeBuckets[1] = fishAgeBuckets[2]
        fishAgeBuckets[2] = fishAgeBuckets[3]
        fishAgeBuckets[3] = fishAgeBuckets[4]
        fishAgeBuckets[4] = fishAgeBuckets[5]
        fishAgeBuckets[5] = fishAgeBuckets[6]
        fishAgeBuckets[6] = fishAgeBuckets[7] + zeroAgeFish
        fishAgeBuckets[7] = fishAgeBuckets[8]
        fishAgeBuckets[8] = zeroAgeFish
        
    }
    println(fishAgeBuckets.sum())
}
main()