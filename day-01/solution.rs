// cargo-deps: commons = { path = "../commons" }
fn main() {
    let lines = io::read_lines("day-01/input.txt");
    let nums = lines
        .unwrap()
        .map(|line| line.unwrap().parse::<i32>().unwrap())
        .collect::<Vec<i32>>();
    let mut threesums: Vec<i32> = vec![0; nums.len() - 2];
    for i in 0..threesums.len() {
        threesums[i] = nums[i] + nums[i + 1] + nums[i + 2];
    }
    let mut count = 0;
    for i in 1..threesums.len() {
        if threesums[i] > threesums[i - 1] {
            count += 1;
        }
    }
    println!("{}", count);
}
