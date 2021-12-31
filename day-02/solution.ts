import { readLines } from "../commons/io.ts";

function main() {
    const lines = readLines("day-02/input.txt")
    let aim = 0
    let depth = 0
    let hPos = 0

    lines.forEach((line) => {
        const commands = line.split(" ")
        const dir = commands[0]
        const steps = parseInt(commands[1])

        switch (dir) {
            case "forward":
                hPos += steps
                depth += (aim * steps)
                break;
            case "up":
                aim -= steps
                break;
            case "down":
                aim += steps
                break;
        }
    })
    console.log(`hPos = ${hPos}, depth = ${depth}, ans = ${depth * hPos}`)
}

main()