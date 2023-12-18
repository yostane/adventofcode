import re
from day12_utils import memoize
from typing import List


def generate_all_oossibilities(length: int) -> List[str]:
    components = [".", "#"]
    possibilities: [str] = components[:]
    for i in range(length - 1):
        possibilities = [f"{x}{y}" for x in possibilities for y in components]
    return possibilities


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
    generate_all_oossibilities_memoized = memoize(generate_all_oossibilities)
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
    expanded_lines = [f"{"?".join(list(l[0]) * 5)} {",".join(list(l[1]) * 5)}" for l in splitted_lines]
    return expanded_lines


def run_step_1(input: str) -> int:
    expanded_lines = expand(input)
    counts = [len(get_correct_possibilities(x)) for x in expanded_lines]
    return sum(counts)
