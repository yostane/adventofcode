enum Direction {
    case Left, Right
}

typealias Nodes = [String: (String, String)]
typealias NodeElement = Dictionary<String, (String, String)>.Element

struct Map{
    let startNodeName = "AAA"
    let endNodeName = "ZZZ"
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
        var stepCount = 0
        var currentNodeName = startNodeName
        while (currentNodeName != endNodeName){
            guard let node = (nodes.first{ $0.key == currentNodeName }) else {
                print("node not found")
                return 0
            }
            currentNodeName = getNextNodeName(of: node, direction: getDirection(forStep: stepCount))
            stepCount += 1
        }
        return stepCount
    }

    func getDirection(forStep step: Int) -> Direction {
        directions[step % directions.count]
    }

    func getNextNodeName(of node: NodeElement, direction: Direction) -> String{
        return if direction == .Left {node.value.0} else {node.value.1}
    }

    func runStep2() -> Int {
        var stepCount = 0
        var currentNodeNames = nodes.filter { $0.key.hasSuffix("A") }.map { $0.key }
        while (!currentNodeNames.allSatisfy{ $0.hasSuffix("Z") }){
            let direction = getDirection(forStep: stepCount)
            currentNodeNames = currentNodeNames.map { element in
                let possibilities: (String, String)! = nodes[element]
                return if direction == .Left {possibilities.0 } else { possibilities.1}
            }
            print(currentNodeNames)
            stepCount += 1
        }
        return stepCount
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

