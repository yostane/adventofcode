import Foundation

enum Direction {
    case Left, Right
}

typealias Nodes = [String: (String, String)]
typealias NodeElement = Dictionary<String, (String, String)>.Element

struct Map{
    let directions: [Direction]
    let nodes: Nodes
    
    static func load(from input: String) -> Map {
        let parts = input.split(separator: "\n\n")
        let directions = parts[0].map { if $0 == "L" {Direction.Left} else {Direction.Right} }
        let nodes = parts[1].split(separator: "\n").reduce(into: Nodes()) { result, line in
            let splitLine = line.split(separator: " = ")
            let destinationsParts = splitLine[1]
            let startIndex = destinationsParts.startIndex + 1
            let endIndex = destinationsParts.endIndex - 1
            let preprocessedDestinations = destinationsParts[startIndex..<endIndex]
            let destinations = preprocessedDestinations
                .split(separator: ", ")
                .map { String($0) }
            result[String(splitLine[0])] = (destinations[0], destinations[1])
        }
        return Map(directions: directions, nodes: nodes)
    }
    
    func runStep1() -> Int {
        findExit(of: "AAA").1
    }

    func findExit(of startNodeName: String) -> (String, Int) {
        let endNodeName = startNodeName.replacing("A", with: "Z").filter {$0 == "Z"}
        print("finding exit of", startNodeName, ". The exit should end with", endNodeName)
        var stepCount = 0
        var currentNodeName = startNodeName
        while !currentNodeName.hasSuffix(endNodeName) {
            guard let node = (nodes.first{ $0.key == currentNodeName }) else {
                print("node not found")
                return ("", 0)
            }
            currentNodeName = getNextNodeName(of: node, direction: getDirection(forStep: stepCount))
            stepCount += 1
        }
        let result = (currentNodeName, stepCount)
        print("found exit", result)
        return result
    }

    func getDirection(forStep step: Int) -> Direction {
        directions[step % directions.count]
    }

    func getNextNodeName(of node: NodeElement, direction: Direction) -> String{
        return if direction == .Left {node.value.0} else {node.value.1}
    }

    func runStep2Attempt1() -> Int {
        var stepCount = 0
        var currentNodeNames = nodes.filter { $0.key.hasSuffix("A") }.map { $0.key }
        while currentNodeNames.count > 0 {
            let direction = getDirection(forStep: stepCount)
            currentNodeNames = currentNodeNames.map { element in
                let possibilities: (String, String)! = nodes[element]
                let newNodeName = if direction == .Left {possibilities.0 } else { possibilities.1}
                if newNodeName.hasSuffix("Z"){
                    print("match", element, newNodeName, stepCount, stepCount % directions.count)
                }
                return newNodeName
            }
            
            stepCount += 1
        }
        return stepCount
    }

        // work with any sort of input and output as long as the input is hashable, accept a function that takes Input and returns Output, and send back a function that accepts Input and returns Output
    func memoize<Input: Hashable, Output>(_ function: @escaping (Input) -> Output) -> (Input) -> Output {
        // our item cache
        var storage = [Input: Output]()

        // send back a new closure that does our calculation
        return { input in
            if let cached = storage[input] {
                return cached
            }

            let result = function(input)
            storage[input] = result
            return result
        }
    }

    func isPrime(_ n: Int) -> Bool {
        !(2...(n/2)+1).contains { n.isMultiple(of: $0) }
    }

    func getPrimeMultipliers(_ number: Int) -> [Int] {
        let memoizedPrime = memoize(isPrime)
        return switch(number){
            case 2: [2]
            case 3: [3]
            default: (2...(number/2)+1).filter { number.isMultiple(of: $0) && memoizedPrime($0) }
        }
    }

    func getPrimeMultipliers(_ numbers: [Int]) -> [Int] {
        Array(Set(numbers.flatMap { getPrimeMultipliers($0) }))
    }

    func runStep2() -> Int {
        let currentNodeNames = nodes.filter { $0.key.hasSuffix("A") }.map { $0.key }
        let exits = currentNodeNames.map { findExit(of: $0) }
        let exitSteps = exits.map { Int($0.1) }
        print("exit steps", exitSteps)
        guard let max = exitSteps.max() else {
            return 0
        }
        let mult = exitSteps.map { Double($0) }.reduce(1.0, *)
        print("mult", mult, NSDecimalNumber(string: "\(mult)"))

        let primes = getPrimeMultipliers(exitSteps)
        let result = primes.reduce(1, *)

        // print("findind smallest multiplier. Starting with", max)
        // var result = max
        // while (!exitSteps.allSatisfy{ result.isMultiple(of: $0)}) {
        //     result += 1
        // }
        return result
    }
}

let testMap1 = Map.load(from: TEST_INPUT_1)
print("result test 1:", testMap1.runStep1(), ". expected: 6")
let testMap2 = Map.load(from: TEST_INPUT_2)
print("result test 2:", testMap2.runStep1(), ". expected: 5")
let map = Map.load(from: PUZZLE_INPUT)
print("result test 2", map.runStep1())

let testMapStep2 = Map.load(from: TEST_INPUT_PART_2)
print("result test step 2:", testMapStep2.runStep2(), ". expected: 6")
print("result step 2:", map.runStep2())

