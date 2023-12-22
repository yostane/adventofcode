from day12 import run_step_1, run_step_2
from input_data import puzzle_input

if __name__ == "__main__":
    print("day 12")
    # print("step 1", run_step_1(puzzle_input))
    print(
        "step test",
        run_step_2(".??..??...?##. 1,1,3"),
    )
    print("step test", run_step_1("?.??..??...?##. 1,1,3"))
    print("step test", run_step_1("????.######..#####.? 1,6,5"))
    print("step test", run_step_1("?????.######..#####. 1,6,5"))
    print("step test", run_step_1("?###????????? 3,2,1"))
