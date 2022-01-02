use std::fs::File;
use std::io::{self, BufRead};

pub fn read_lines(filename: &str) -> Vec<String> {
    let file = File::open(filename).expect("Unable to open file");
    let lines = io::BufReader::new(file).lines()
        .map(|l| l.unwrap())
        .collect::<Vec<String>>();
    return lines
}