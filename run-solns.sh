#!/usr/bin/env sh 

# run go solutions
go run day-01/solution.go
go run day-02/solution.go

# run kotlin solutions
kscript day-01/solution.kt
kscript day-02/solution.kt

# run rust solutions
rust-script day-01/solution.rs
rust-script day-02/solution.rs

# run typescript solutions
deno run -A day-01/solution.ts
deno run -A day-02/solution.ts