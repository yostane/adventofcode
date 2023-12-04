from puzzle_input import sample_input, puzzle_input

#lines = sample_input.splitlines()
lines = puzzle_input.splitlines()

def compute_score(win_string: str, played_string: str) -> int:
    wins = [int(x) for x in win_string.split()]
    plays = [int(x) for x in played_string.split()] 
    print(wins, plays)
    correct_guesses = len([1 for x in wins for y in plays if x == y])
    # sum of n terms of geometric number suite u(n) = 2*u(n-1) (with indexing starting from 0)
    # u(n) = u(0) * 2^n -> u(0) is 1 and n correct_guesses - 1
    return 2**(correct_guesses - 1) if correct_guesses > 0 else 0

"""ingore the "game xxx: " part and split between winning and playing parts """
split1_games = [game.split(": ")[1].split(" | ") for game in lines]
# print(split1_games)
scores = [compute_score(x[0], x[1]) for x in split1_games]
print("scores", scores, "result", sum(scores))