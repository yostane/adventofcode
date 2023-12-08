enum Direction {
    case Left, Right
}

typealias Nodes = [String: (String, String)]

struct Map{
    let startNodeName = "AAA"
    let endNodeName = "ZZZ"
    let directions: [Direction]
    let nodes: Nodes
    
    static func load(from input: String) -> Map {
        let parts = input.split(separator: "\n\n")
        let directions = parts[0].map { if $0 == "L" { Direction.Left} else {Direction.Left} }
        let nodes = parts[1].split(separator: "\n").reduce(into: Nodes()) { result, line in
            let splitLine = line.split(separator: " = ")
            let destinationsParts = splitLine[1]
            let startIndex = destinationsParts.index(after: destinationsParts.startIndex)
            let endIndex = destinationsParts.index(destinationsParts.endIndex, offsetBy: -1)
            let preprocessedDestinations = destinationsParts[startIndex...endIndex]
            let destinations = preprocessedDestinations
                .split(separator: ", ")
                .map { String($0) }
            result[String(splitLine[0])] = (destinations[0], destinations[1])
        }
        return Map(directions: directions, nodes: nodes)
    }
    
    func runStep1() -> Int {
        var stepCount = 0
        var currentNodeName = startNodeName
        while (currentNodeName != endNodeName){
            guard let node = (nodes.first{ $0.key == currentNodeName }) else {
                return 0
            }
            let currentDirection = directions[stepCount % directions.count]
            currentNodeName = if currentDirection == .Left {node.value.0} else {node.value.1}
            stepCount += 1
        }
        return stepCount - 1
    }
}

let testMap1 = Map.load(from: TEST_INPUT_1)
assert(testMap1.runStep1() == 2)
let testMap2 = Map.load(from: TEST_INPUT_2)
assert(testMap1.runStep1() == 6)
