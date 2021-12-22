package main

import (
	commons_io "commons"
	"fmt"
	"strconv"
	"strings"
)

func main() {
	lines := commons_io.ReadLines("day-02/input.txt")
	aim := 0
	depth := 0
	hPos := 0

	for _, line := range lines {
		commands := strings.Split(line, " ")
		steps, err := strconv.Atoi(commands[1])

		if err != nil {
			panic(err)
		}

		switch commands[0] {
		case "forward":
			hPos += steps
			depth += (aim * steps)
		case "up":
			aim -= steps
		case "down":
			aim += steps
		}
	}

	fmt.Printf("hPos = %v, depth = %v, ans = %v \n", hPos, depth, hPos*depth)

}
