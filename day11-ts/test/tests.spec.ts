import { testInput } from "../src/input-data";
import { runStep1 } from "../src/utils";

describe("testing day 11", () => {
  test("step 1", () => {
    expect(runStep1(testInput)).toBe(0);
  });
});
