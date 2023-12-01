// https://adventofcode.com/2023/day/1

import Foundation
import FoundationNetworking

guard  else {
    
    throw MyError.UrlError
}
guard let url = URL(string: "https://adventofcode.com/2023/day/1/input"),
        let let (data, _) = try? await URLSession.shared.data(from: url) else {
    print("Failed")
    exit(1)
}

let str = String(decoding: data, as: UTF8.self)
let lines = str.components(separatedBy: "\n")

lines.map { line in 
    line.filter { char in "0123456789".contains(char) }
}

print(lines)