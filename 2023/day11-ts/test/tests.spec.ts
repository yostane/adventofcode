import { puzzleInput, testInput } from "../src/input-data";
import { Planet } from "../src/model";
import {
  countColumnsEmpty,
  countRowsEmpty as countEmptyRows,
  expandUniverse,
  findPlanets,
  runStep1,
  runStep2,
} from "../src/utils";

const expandedUniverse = `....#........
.........#...
#............
.............
.............
........#....
.#...........
............#
.............
.............
.........#...
#....#.......`;

describe("testing day 11", () => {
  test("expand universe", () => {
    const actual = expandUniverse(testInput).join("\n");
    expect(actual).toBe(expandedUniverse);
  });

  test("find planets simple", () => {
    const universe = [".....#"];
    expect(findPlanets(universe)).toStrictEqual([new Planet(1, 0, 5)]);
  });

  test("find planets with more complex data", () => {
    const universe = [".....#", ".....##..."];
    expect(findPlanets(universe)).toStrictEqual([
      new Planet(1, 0, 5),
      new Planet(2, 1, 5),
      new Planet(3, 1, 6),
    ]);
  });

  test("simple distances", () => {
    const input = ".#...#";
    const actual = runStep1(input);
    expect(actual).toBe(7);
  });

  test("step 1", () => {
    expect(runStep1(testInput)).toBe(374);
  });

  test("count emptly lines and columns", () => {
    const universeLines = testInput.split("\n");
    const actual1 = countEmptyRows(universeLines, 2, 4);
    const actual2 = countColumnsEmpty(universeLines, 1, 6);
    expect(actual1).toBe(1);
    expect(actual2).toBe(2);
  });

  test("step 2 on puzzle input 10", () => {
    const actual = runStep2(testInput, 10);
    expect(actual).toBe(1030);
  });

  test("step 2 on puzzle input 100", () => {
    const actual = runStep2(testInput, 100);
    expect(actual).toBe(8410);
  });
});
