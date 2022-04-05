use std::fs;
use std::fs::File;

pub fn read_lines(filename: &str) -> Vec<String> {
    let data = fs::read_to_string(filename).expect("Failed to read file");
    let lines = data.lines()
        .map(|l| l.unwrap())
        .collect::<Vec<String>>();
    return lines;
}