// cargo-deps: commons = { path = "../commons" }
fn main() {
    let lines = io::read_lines("day-02/input.txt");
    let mut aim = 0;
    let mut depth = 0;
    let mut h_pos = 0;

    lines.iter().for_each(|line| {
        let commands = line.split(" ").collect::<Vec<&str>>();
        let dir = commands[0];
        let steps = commands[1].parse::<i32>().unwrap();

        match dir {
            "forward" => {
                h_pos += steps;
                depth += aim * steps
            }
            "up" => {
                aim -= steps;
            }
            "down" => {
                aim += steps;
            }
            _ => {}
        }
    });

    println!("hPos = {}, depth = {}, ans = {}", h_pos, depth, depth * h_pos);
}