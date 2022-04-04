package main

import (
	cio "commons"
	"strconv"
	"strings"
)

func part1(lines []string) int64 {
	rays := len(lines[0])
	points := len(lines)

	rayVals := make([]int, rays)

	for _, line := range lines {
		for i, v := range line {
			if v == '1' {
				rayVals[i]++
			}
		}
	}

	gammaRate := make([]string, rays)
	epsilonRate := make([]string, rays)

	for i, val := range rayVals {
		if val > points/2 {
			gammaRate[i] = "1"
		} else {
			gammaRate[i] = "0"
		}

		if val < points/2 {
			epsilonRate[i] = "1"
		} else {
			epsilonRate[i] = "0"
		}
	}

	gammaPower, _ := strconv.ParseInt(strings.Join(gammaRate, ""), 2, 64)
	epsilonPower, _ := strconv.ParseInt(strings.Join(epsilonRate, ""), 2, 64)

	println(gammaPower)
	println(epsilonPower)

	return epsilonPower * gammaPower

}

func main() {
	lines := cio.ReadLines("day-03/input.txt")
	powerRating := part1(lines)

	println(powerRating)

}
