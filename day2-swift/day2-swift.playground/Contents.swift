
import Foundation

func extractInt(from input: String.SubSequence) -> Int {
    Int(input.filter { $0.isNumber }) ?? 0
}

let lines = puzzleInput.split(separator: "\n")
//let result = lines.map { line in
//    let parts = line.split(separator: ":")
//    let cubeSets = parts[1].split(separator: ";").flatMap { $0.split(separator: ",") }.map{ $0.trimmingCharacters(in: .whitespacesAndNewlines)}.map { $0.split(separator: " ") }
////    print(cubeSets)
//    let cubeCounts = cubeSets.reduce(into: [String: Int]()) { r, cur in
////        print(r, cur)
//        r[String(cur[1]), default: 0] += extractInt(from: cur[0])
//    }
////    print(cubeCounts)
//    let game = extractInt(from: parts[0])
//    guard cubeCounts["red"] ?? 0 <= 12, cubeCounts["green"] ?? 0 <= 13 , cubeCounts["blue"] ?? 0 <= 14 else {
//        return 0
//    }
//    print(game, cubeCounts)
//    return game
//}.reduce(0, +)
//print(result)

let games = lines.map { line in
    let parts = line.split(separator: ": ")
    let game = extractInt(from: parts[0])
    let cubeSets = parts[1].split(separator: "; ").flatMap {
        $0.split(separator: ", ")
    }.flatMap {
        let colorAndCount = $0.split(separator: " ")
        let name = String(colorAndCount[1])
        let count = extractInt(from: colorAndCount[0])
        return (name, count)
    }
    return (game, cubeSets)
}

let result = games.map { item in
    let (game, cubeSets) = item
    let isImpossible = cubeSets.contains { item in
        let (name, count) = item
        return (name == "red" && count > 12) || (name == "green" && count > 13) || (name == "blue" && count > 14)
    }
    print(game, isImpossible, cubeSets)
    return if isImpossible { 0 } else { game }
}.reduce(0, +)
print("part 1", result)

let result2 = lines.map { line in
    let parts = line.split(separator: ": ")
    let game = extractInt(from: parts[0])
    let cubeSets = parts[1].split(separator: "; ").flatMap {
        $0.split(separator: ", ")
    }.flatMap {
        let colorAndCount = $0.split(separator: " ")
        let name = String(colorAndCount[1])
        let count = extractInt(from: colorAndCount[0])
        return (name, count)
    }
    let maxCounts = cubeSets.reduce(into: [String:Int]()) { result, item in
        let (name, count) = item
        result[name] = max(result[name, default: 0], count)
    }
    let power =  maxCounts.map { $0.1 }.reduce(1, *)
    print(game, power, maxCounts)
    return power
}.reduce(0, +)
print("part 2", result2)
