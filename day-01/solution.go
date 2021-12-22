package main

import (
	commons_io "commons"
	"strconv"
)

func main() {
	lines := commons_io.ReadLines("day-01/input.txt")
	nums := make([]int, len(lines))
	for i, line := range lines {
		n, err := strconv.Atoi(line)
		if err != nil {
			panic(err)
		}
		nums[i] = n
	}

	threesum := make([]int, len(nums)-2)
	for i := 0; i < len(nums)-2; i++ {
		threesum[i] = nums[i] + nums[i+1] + nums[i+2]
	}
	count := 0
	for i := 1; i < len(threesum); i++ {
		if threesum[i] > threesum[i-1] {
			count++
		}
	}
	println(count)
}
