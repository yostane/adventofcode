def memoize(f):
    """Source: https://python-course.eu/advanced-python/memoization-decorators.php"""
    memo = {}

    def helper(x):
        if x not in memo:
            memo[x] = f(x)
        return memo[x]

    return helper
