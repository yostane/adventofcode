package main

import "fmt"

func runStep1(input string) int {
	return 0
}

func main() {
	for i, v := range SampleInputs {
		fmt.Printf("Sample input %d\n", i)
		result := runStep1(v)
		fmt.Printf("Result %d\n", result)
	}
}
