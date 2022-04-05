import { readLines } from "../commons/io.ts";

function part1(lines: Array<string>): number {
  const rays = lines[0].length;
  const points = lines.length;

  const rayVals = new Array(rays).fill(0);

  lines.forEach((line) => {
    line.split("").forEach((char, index) => {
      if (char === "1") rayVals[index]++;
    });
  });
  const gammaRate = rayVals.map((val) => (val > points / 2) ? 1 : 0);
  const epsilonRate = rayVals.map((val) => (val < points / 2) ? 1 : 0);

  const gammaPower = parseInt(gammaRate.join(""), 2);
  const epsilonPower = parseInt(epsilonRate.join(""), 2);

  console.log(gammaPower);
  console.log(epsilonPower);

  return gammaPower * epsilonPower;
}

function main() {
  const lines = readLines("day-03/input.txt");

  const powerRating = part1(lines);
  console.log(powerRating);
}

main();