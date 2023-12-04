from puzzle_input import sample_input, puzzle_input
from typing import List

# lines = sample_input.splitlines()
lines = puzzle_input.splitlines()


def get_card_match_count(card: List[str]) -> int:
    wins = [int(x) for x in card[0].split()]
    plays = [int(x) for x in card[1].split()]
    print(wins, plays)
    correct_guesses = len([1 for x in wins for y in plays if x == y])
    return correct_guesses


def get_card_score(card: List[str]) -> int:
    correct_guesses = get_card_match_count(card)
    # sum of n terms of geometric number suite u(n) = 2*u(n-1) (with indexing starting from 0)
    # u(n) = u(0) * 2^n -> u(0) is 1 and n correct_guesses - 1
    return 2 ** (correct_guesses - 1) if correct_guesses > 0 else 0


"""ingore the "game xxx: " part and split between winning and playing parts """
cards = [game.split(": ")[1].split(" | ") for game in lines]
# print(split1_games)
scores = [get_card_score(x) for x in cards]
print("scores", scores, "result", sum(scores))

card_copies = [1] * len(scores)

for i in range(len(scores)):
    match_count = get_card_match_count(cards[i])
    if match_count == 0:
        continue
    for j in range(i + 1, i + match_count + 1):
        card_copies[j] += card_copies[i]

print(card_copies)
print("result 2", sum(card_copies))
