@file:Include("../commons/io.kts")

fun main() {
    val lines: List<String> = readLines("day-02/input.txt")
    var aim = 0
    var depth = 0
    var hPos = 0

    lines.forEach { line ->
        val commands = line.split(" ")
        val dir = commands[0]
        val steps = commands[1].toInt()

        when (dir) {
            "forward" -> {
                hPos += steps
                depth += (aim * steps)
            }
            "up" -> {
                aim -= steps
            }
            "down" -> {
                aim += steps
            }
        }
    }

    println("hPos = ${hPos}, depth = ${depth}, ans = ${depth * hPos}")
}
main()