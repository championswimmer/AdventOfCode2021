package main

import (
	commons_io "commons"
	"strconv"
	"strings"
)

func main() {
	line := commons_io.ReadLines("day-06/input.txt")[0]
	chars := strings.Split(line, ",")

	fishAges := make([]int64, len(chars))
	for i, c := range chars {
		age, _ := strconv.Atoi(c)
		fishAges[i] = int64(age)
	}
	fishAgeBuckets := make([]int64, 9)
	for _, age := range fishAges {
		fishAgeBuckets[age]++
	}

	for i := 0; i < 256; i++ {
		zeroAgeFish := fishAgeBuckets[0]
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

	fishSum := int64(0)
	for _, fish := range fishAgeBuckets {
		fishSum += fish
	}

	println(fishSum)

}
