import { puzzleInput } from "./puzzle-input";
import { sampleInput } from "./sample-input";

const lines = puzzleInput.split("\n");
// const lines = sampleInput.split("\n");

function hasSymbol(line: String, start: number, end: number): boolean {
  for (let i = Math.max(start, 0); i < Math.min(end, line.length); i++) {
    if (line[i] != "." && isNaN(Number(line[i]))) {
      return true;
    }
  }
  return false;
}

/**
 * Checks in squar (i-1; j-1) to (i+1; k)
 * @param lines
 * @param i curret line index
 * @param j start index of the number
 * @param k end index of the number
 */
function hasAdjacentSymbol(
  lines: string[],
  lineIndex: number,
  startColumn: number,
  endColumn: number
): boolean {
  for (
    let i = Math.max(0, lineIndex - 1);
    i <= Math.min(lineIndex + 1, lines.length - 1);
    i++
  ) {
    if (hasSymbol(lines[i], startColumn - 1, endColumn + 1)) {
      return true;
    }
  }
  return false;
}

const numbers: number[] = [];
for (let i = 0; i < lines.length; i++) {
  const line = lines[i];
  for (let j = 0; j < line.length; j++) {
    const current = line[j];
    if (isNaN(Number(current))) {
      continue;
    }
    // j is the start index of the number. k is the end index
    let numberAsString = current;
    let k = 0;
    for (k = j + 1; !isNaN(Number(line[k])) && k < line.length; k++) {
      numberAsString += line[k];
    }
    if (hasAdjacentSymbol(lines, i, j, k)) {
      numbers.push(Number(numberAsString));
    }
    j = k - 1;
  }
}

console.log(
  "part 1",
  numbers,
  numbers.reduce((p, current) => p + current, 0)
);

function findAdjacentNumbersOnLine(
  line: string,
  columnIndex: number
): number[] {
  let startIndex = 0;
  for (
    startIndex = columnIndex - 1;
    startIndex >= 0 && !isNaN(Number(line[startIndex]));
    startIndex--
  ) {}

  startIndex = Math.max(0, startIndex);

  let endIndex = 0;
  for (
    endIndex = columnIndex + 1;
    endIndex < line.length && !isNaN(Number(line[endIndex]));
    endIndex++
  ) {}

  const sub = line.substring(startIndex, endIndex);
  const split = sub.split(/\.|\*/).filter((s) => s.length > 0);
  return split.map((item) => Number(item)).filter((n) => !isNaN(n) && n > 0);
}

function findAdjacentNumbers(
  lines: string[],
  lineIndex: number,
  columnIndex: number
): number[] {
  const numbers: number[] = [];
  for (
    let i = Math.max(0, lineIndex - 1);
    i < Math.min(lineIndex + 2, lines.length);
    i++
  ) {
    numbers.push(...findAdjacentNumbersOnLine(lines[i], columnIndex));
  }
  return numbers;
}

const gearRatios: number[] = [];

for (let i = 0; i < lines.length; i++) {
  const line = lines[i];
  for (let j = 0; j < line.length; j++) {
    const current = line[j];
    if (current != "*") {
      continue;
    }
    const adjacentNumbers = findAdjacentNumbers(lines, i, j);
    console.log(adjacentNumbers);
    if (adjacentNumbers.length == 2) {
      const gearRatio = adjacentNumbers.reduce((r, cur) => r * cur, 1);
      gearRatios.push(gearRatio);
    }
  }
}

console.log(
  "part 2",
  gearRatios,
  gearRatios.reduce((p, current) => p + current, 0)
);
