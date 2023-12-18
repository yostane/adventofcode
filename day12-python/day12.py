import re
from day12_utils import memoize
from typing import List


def generate_all_possibilities(length: int) -> List[str]:
    components = [".", "#"]
    possibilities: [str] = components[:]
    for i in range(length - 1):
        possibilities = [x + y for x in possibilities for y in components]
    return possibilities

def yield_all_possibilities(length: int) -> List[str]:
    current_possibility = ["."] * length
    char_to_append = "."
    char_to_move = "#"
    yield "".join(current_possibility)
    current_possibility[-1] = "#"
    yield "".join(current_possibility)
    yielded = 2
    to_yield = 2 ** length
    while yielded < to_yield:
        if current_possibility[0] != char_to_move:
            current_possibility.append(char_to_append)
            current_possibility.pop(0)
        else:
            move_count = current_possibility.count(char_to_move)
            if move_count < len(current_possibility):
                append_count = len(current_possibility) - move_count - 1 
                current_possibility = [char_to_append] * append_count + [char_to_move] * (move_count + 1)
            else:
                char_to_move = "."
                char_to_append = "#"
                current_possibility[-1] = char_to_move
                continue
        yield "".join(current_possibility)
        yielded += 1

        

def apply_possibity_to_spring_statuses(
    possibility: str, spring_states: str, question_positions: List[str]
) -> str:
    result = list(spring_states)
    for i in range(len(question_positions)):
        result[question_positions[i]] = possibility[i]
    return "".join(result)


def is_row_correct(spring_statuses: str, damage_records: List[int]) -> bool:
    damaged_springs = re.split(r"\.+", spring_statuses)
    damages_springs_counts = [l for x in damaged_springs if (l := len(x)) and l > 0]
    return damages_springs_counts == damage_records


def get_correct_possibilities(row: str) -> int:
    [springs_statuses, damage_records_string] = row.split(" ")
    damage_records = [int(x) for x in damage_records_string.split(",")]
    question_positions = [
        x for x in range(len(springs_statuses)) if springs_statuses[x] == "?"
    ]
    generate_all_oossibilities_memoized = generate_all_possibilities
    possiblities = generate_all_oossibilities_memoized(len(question_positions))
    correct_possibilities = [
        p
        for x in possiblities
        if (
            p := apply_possibity_to_spring_statuses(
                x, springs_statuses, question_positions
            )
        )
        and is_row_correct(p, damage_records)
    ]
    return correct_possibilities


def run_step_1(input: str) -> int:
    lines = input.split("\n")
    counts = [len(get_correct_possibilities(x)) for x in lines]
    return sum(counts)


def expand(input: str) -> List[str]:
    lines = input.split("\n")
    splitted_lines = [line.split(" ") for line in lines]
    expanded_lines = [f"{"?".join([l[0]] * 5)} {",".join([l[1]] * 5)}" for l in splitted_lines]
    return expanded_lines


def run_step_2(input: str) -> int:
    expanded_lines = expand(input)
    counts = [len(get_correct_possibilities(x)) for x in expanded_lines]
    return sum(counts)
