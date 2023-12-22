import unittest
import re
from day12 import *
from input_data import test_input_1_possibilities, test_input_1


class Testing(unittest.TestCase):
    def test_re_split(self):
        self.assertEqual(re.split(r"\.+", "#...###.###"), ["#", "###", "###"])
        pass

    def test_is_row_correct(self):
        self.assertEqual(is_row_correct("#...###.###", [1, 3, 3]), True)
        pass

    def test_generate_all_possibilities(self):
        expected = ["...", "..#", ".##", "###", "#..", "##.", "#.#", ".#."]
        self.assertCountEqual(generate_all_possibilities(3), expected)
        pass

    def test_get_correcet_possibilities_cout(self):
        for input, count in test_input_1_possibilities.items():
            self.assertEqual(len(get_correct_possibilities_of_row(input)), count[0])

    def test_step_1(self):
        self.assertEqual(run_step_1(test_input_1), 21)

    def test_expand_1(self):
        self.assertEqual(expand(".# 1"), [".#?.#?.#?.#?.# 1,1,1,1,1"])

    def test_step_2(self):
        for input, _ in test_input_1_possibilities.items():
            result = run_step_2(input)
            print(input, "step 2 ->", result)

        for input, counts in test_input_1_possibilities.items():
            result = run_step_2(input)
            self.assertEqual(result, counts[1], input)

    def test_expanded_possibilities(self):
        for input, _ in test_input_1_possibilities.items():
            result = get_correct_possibilities_of_expanded_row(input)
            print(input, "expanded possibilities ->", [len(x) for x in result])

        for input, counts in test_input_1_possibilities.items():
            result = get_correct_possibilities_of_expanded_row(input)
            actuals = [len(x) for x in result]
            self.assertEqual((actuals[0] ** 4) * actuals[1], counts[1], input)

    def test_yield_all_possibilities_1(self):
        expected = ["...", "..#", ".##", "###", "#..", "##.", "#.#", ".#."]
        self.assertCountEqual(yield_all_possibilities_recursive(3), expected)

    def test_yield_all_possibilities_2(self):
        self.assertCountEqual(
            yield_all_possibilities_recursive(4), generate_all_possibilities(4)
        )


if __name__ == "__main__":
    unittest.main()
