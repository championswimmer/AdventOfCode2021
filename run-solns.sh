#!/usr/bin/env sh 

## run go solutions
#go run day-01/solution.go
#go run day-02/solution.go
#
## run kotlin solutions
#kscript day-01/solution.kts
#kscript day-02/solution.kts
#
## run rust solutions
#rust-script day-01/solution.rs
#rust-script day-02/solution.rs
#
## run typescript solutions
#deno run -A day-01/solution.ts
#deno run -A day-02/solution.ts

solve() {
    LANG=$1
    DAY=$2

    case $LANG in
    "go" | "golang")
      RUN_CMD="go run"
      EXT=".go"
      ;;
    "kt" | "kotlin")
      RUN_CMD="kscript"
      EXT=".kts"
      ;;
    "rs" | "rust")
      RUN_CMD="rust-script"
      EXT=".rs"
      ;;
    "ts" | "typescript")
      RUN_CMD="deno run -A"
      EXT=".ts"
      ;;
    esac

    echo "Running $LANG solution for day $DAY"
    time $RUN_CMD day-"$DAY"/solution$EXT
}

if [ -z "$1" ]
  then
    echo "No language specified"
    exit 1
fi

if [ -z "$2" ]
  then
    echo "No day specified"
    exit 1
fi

solve "$1" "$2"