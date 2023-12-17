import { Planet } from "./model";

export function expandUniverse(input: string): string[] {
  let lines = input.split("\n");
  // duplicate empty lines
  for (let i = lines.length - 1; i >= 0; i--) {
    if (!lines[i].includes("#")) {
      lines = [...lines.slice(0, i), lines[i], ...lines.slice(i)];
    }
  }
  // duplicate emprty columns

  for (let j = lines[0].length - 1; j >= 0; j--) {
    let i = 0;
    for (i = 0; i < lines.length; i++) {
      if (lines[i][j] != ".") {
        break;
      }
    }
    // No planet found
    if (i == lines.length) {
      for (i = 0; i < lines.length; i++) {
        lines[i] = lines[i].substring(0, j) + "." + lines[i].substring(j);
      }
    }
  }
  return lines;
}

export function findPlanets(universeLines: string[]): Planet[] {
  const planets: Planet[] = [];
  for (let i = 0; i < universeLines.length; i++) {
    const line = universeLines[i];
    let index = line.indexOf("#");
    while (index >= 0) {
      planets.push(new Planet(planets.length + 1, i, index));
      index = line.indexOf("#", index + 1);
    }
  }
  return planets;
}

export function getMinDistances(plantes: Planet[]): number[] {
  const pairs = plantes
    .slice(0, -1)
    .flatMap((p1) =>
      plantes.filter((p2) => p1.id < p2.id).map((p2) => ({ p1, p2 }))
    );
  const distances = pairs.map(
    (pair) => Math.abs(pair.p1.i - pair.p2.i) + Math.abs(pair.p1.j - pair.p2.j)
  );
  return distances;
}

export function countRowsEmpty(
  universeLines: string[],
  start: number,
  end: number
): number {
  return universeLines.slice(start, end).filter((line) => !line.includes("#"))
    .length;
}

export function countColumnsEmpty(
  universeLines: string[],
  start: number,
  end: number
): number {
  let count = 0;
  for (let j = end - 1; j >= start; j--) {
    let i = 0;
    for (i = 0; i < universeLines.length; i++) {
      if (universeLines[i][j] != ".") {
        break;
      }
    }
    // No planet found
    if (i == universeLines.length) {
      count++;
    }
  }
  return count;
}

export function getMinDistancesWithExpansion(
  plantes: Planet[],
  expansion: number,
  universe: string[]
): number[] {
  const pairs = plantes
    .slice(0, -1)
    .flatMap((p1) =>
      plantes.filter((p2) => p1.id < p2.id).map((p2) => ({ p1, p2 }))
    );
  const distances = pairs.map((pair) => {
    const d = Math.abs(pair.p1.i - pair.p2.i) + Math.abs(pair.p1.j - pair.p2.j);
    const expansionRowCount = countRowsEmpty(
      universe,
      Math.min(pair.p1.i, pair.p2.i),
      Math.max(pair.p1.i, pair.p2.i)
    );
    const expansionColumnCount = countColumnsEmpty(
      universe,
      Math.min(pair.p1.j, pair.p2.j),
      Math.max(pair.p1.j, pair.p2.j)
    );
    return (
      d +
      (expansionColumnCount + expansionRowCount) * expansion -
      (expansionColumnCount + expansionRowCount)
    );
  });
  return distances;
}

export function runStep1(input: string): number {
  const universe = expandUniverse(input);
  const planets = findPlanets(universe);
  const distances = getMinDistances(planets);
  return distances.reduce((acc, cur) => acc + cur, 0);
}

export function runStep2(input: string, expansion: number = 1000000): number {
  const universe = input.split("\n");
  const planets = findPlanets(universe);
  const distances = getMinDistancesWithExpansion(planets, expansion, universe);
  return distances.reduce((acc, cur) => acc + cur, 0);
}
