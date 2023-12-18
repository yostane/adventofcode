import unittest
import re
from day12 import is_row_correct


class Testing(unittest.TestCase):
    def test_re_split(self):
        self.assertEqual(re.split(r"\.+", "#...###.###"), ["#", "###", "###"])
        pass

    def test_is_row_correct(self):
        self.assertEqual(is_row_correct("#...###.###", [1, 3, 3]), True)
        pass


if __name__ == "__main__":
    unittest.main()
