import re


def is_row_correct(springStatuses: str, damageRecords: [int]) -> bool:
    damagedSprings = re.split(r"\.+", springStatuses)
    damagesSpringsCounts = [len(x) for x in damagedSprings]
    return damagesSpringsCounts == damageRecords


def get_arrangement_count(row: str) -> int:
    [springsStatus, damageRecordsString] = row.split(" ")
    damageRecords = [int(x) for x in damageRecordsString.split("\n")]
    ["#", "."]
    return 0


def run_step_1(input: str) -> int:
    lines = input.split("\n")

    return 0
