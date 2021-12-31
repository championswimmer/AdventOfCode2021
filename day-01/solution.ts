import {readLines} from "../commons/io";

function main() {
    const lines = readLines("day-01/input.txt");
    const nums = lines.map(Number);
    const threesums = new Array(nums.length - 1);
    for (let i = 0; i < threesums.length; i++) {
        threesums[i] = nums[i] + nums[i + 1] + nums[i + 2];
    }
    let count = 0;
    for (let i = 1; i <= threesums.length; i++) {
        if (threesums[i] > threesums[i - 1]) {
            count++;
        }
    }
    console.log(count);
}

main()