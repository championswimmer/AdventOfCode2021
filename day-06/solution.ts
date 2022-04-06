import { readLines } from "../commons/io.ts";

function main() {
    const line = readLines("day-06/input.txt")[0];
    const fishAges = line.split("").map(Number);
    const fishAgeBuckets = new Array(9).fill(0);

    fishAges.forEach(age => {
        fishAgeBuckets[age] += 1;
    });

    for (let i = 0; i <= 255; i++) {
        const zeroAgeFish = fishAgeBuckets[0]
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
    console.log(fishAgeBuckets.reduce((a, b) => a + b));
}

main()