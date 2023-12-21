import unittest
import re
from day12 import (
    is_row_correct,
    generate_all_possibilities,
    get_correct_possibilities_of_row,
    run_step_1,
    expand,
    run_step_2,
    run_step_2_test0,
    yield_all_possibilities_recursive,
)
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
            self.assertEqual(len(get_correct_possibilities_of_row(input)), count)

    def test_step_1(self):
        self.assertEqual(run_step_1(test_input_1), 21)

    def test_expand_1(self):
        self.assertEqual(expand(".# 1"), [".#?.#?.#?.#?.# 1,1,1,1,1"])

    def test_step_2(self):
        self.assertEqual(run_step_2(test_input_1), 525152)

    def test_step_2_0(self):
        self.assertEqual(run_step_2_test0("???.### 1,1,3"), 1)
        self.assertEqual(run_step_2_test0(".??..??...?##. 1,1,3"), 16384)
        self.assertEqual(run_step_2_test0(test_input_1), 525152)

    def test_yield_all_possibilities_1(self):
        expected = ["...", "..#", ".##", "###", "#..", "##.", "#.#", ".#."]
        self.assertCountEqual(yield_all_possibilities_recursive(3), expected)

    def test_yield_all_possibilities_2(self):
        self.assertCountEqual(
            yield_all_possibilities_recursive(4), generate_all_possibilities(4)
        )


if __name__ == "__main__":
    unittest.main()
