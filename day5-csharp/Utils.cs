namespace AdvenOfCode2023
{
    record RangeMatch((long, long) Match, (long, long)[] NonMatches);

    public static class Utils
    {
        static (long, long) GetRangeIntersection((long, long) a, (long, long) b)
        {
            long maxOfStart = Math.Max(a.Item1, b.Item1);
            long minOfEnd = Math.Min(a.Item2, b.Item2);
            if (minOfEnd > maxOfStart)
            {
                return new(0, 0);
            }
            return (maxOfStart, minOfEnd);
        }
    }
}
