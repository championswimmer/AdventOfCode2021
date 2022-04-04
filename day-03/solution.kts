@file:Include("../commons/io.kts")

fun part1(lines: List<String>): Int {
    val rays = lines[0].length
    val points = lines.size

    val rayVals = Array(rays) { 0 }

    lines.forEach { line: String ->
        line.toCharArray().forEachIndexed { i: Int, v: Char -> 
            if (v == '1') rayVals[i]++ 
        }
    }
    val gammaRate = rayVals.map { if (it > points / 2) 1 else 0 }
    val epsilonRate = rayVals.map { if (it < points / 2) 1 else 0 }
    
    val gammaPower = (gammaRate.joinToString("").toInt(2))
    val epsilonPower = (epsilonRate.joinToString("").toInt(2))

    println(gammaPower)
    println(epsilonPower)

    return (gammaPower * epsilonPower)
}

fun main() {
    val lines: List<String> = readLines("day-03/input.txt")
    // part 1
    val powerRating = part1(lines)
    println(powerRating)
}
main()
