// cargo-deps: commons = { path = "../commons" }
fn part1(lines: Vec<String>) -> i32 {
    let rays = lines[0].len() as u32;
    let points = lines.len() as u32;

    let mut ray_vals = vec![0; rays as usize];
    for line in lines {
        line.chars().enumerate()
            .for_each(|(i, c)| {
                if c == '1' { ray_vals[i] += 1; }
            });
    }

    let gamma_rate = ray_vals.iter()
        .map(|&v| { if v > points / 2 { 0 } else { 1 } })
        .collect::<Vec<i32>>();


    let epsilon_rate = ray_vals.iter()
        .map(|&v| { if v < points / 2 { 0 } else { 1 } })
        .collect::<Vec<i32>>();

    let gamma_power = isize::from_str_radix(
        gamma_rate.into_iter().map(|i| i.to_string())
            .collect::<String>().as_str(),
        2,
    ).unwrap() as i32;
    let epsilon_power = isize::from_str_radix(
        epsilon_rate.into_iter().map(|i| i.to_string())
            .collect::<String>().as_str(),
        2,
    ).unwrap() as i32;

    return gamma_power * epsilon_power;
}

fn main() {
    let lines = io::read_lines("day-03/input.txt");

    let power_rating = part1(lines);
    println!("{}", power_rating);
}