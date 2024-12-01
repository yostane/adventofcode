using System.Runtime.CompilerServices;
using System.Runtime.InteropServices;
using AdvenOfCode2023;

//const string input = InputData.testInput;
const string input = InputData.input;

string[] parts = input.Split(Environment.NewLine + Environment.NewLine);

var seeds = parts[0]["seeds: ".Length..].Split(" ").Select(long.Parse).ToList();

var stringSteps = parts[1..].Select(part => part.Split($":{Environment.NewLine}")[1]);

long[][] ConvertStepToMatrix(string step) => step.Split(Environment.NewLine).Select(
        line => line.Split(" ").Select(long.Parse).ToArray()
        ).ToArray();

var steps = stringSteps.Select(ConvertStepToMatrix).ToArray() ?? [];

long GetStepOutput(long input, long[][] stepLines) =>
    stepLines.Select(line =>
    {
        // "50 98 2" if input is 100 delta will be 100 - 98 = 2 whih is not in range (98,99)
        long delta = input - line[1];
        if (delta < 0 || delta >= line[2])
        {
            return -1;
        }
        long output = line[0] + delta;
        return output;
    }).FirstOrDefault(output => output >= 0, input);

Dictionary<long, long> memoizedSeedLocations = [];
Dictionary<(int, long), long> memoizedStepOutputs = [];

long GetSeedLocation(long seed, long[][][] steps)
{
    if (memoizedSeedLocations.TryGetValue(seed, out long value))
    {
        return value;
    }
    long output = seed;
    for (int i = 0; i < steps.Length; i++)
    {
        if (memoizedStepOutputs.TryGetValue((i, output), out long stepOutput))
        {
            output = stepOutput;
        }
        else
        {
            var input = GetStepOutput(output, steps[i]);
            memoizedStepOutputs[(i, output)] = input;
            output = input;
        }
    }
    memoizedSeedLocations[seed] = output;
    return output;
}

IEnumerable<long> GetLocations(IEnumerable<long> seeds) => seeds.Select(seed => GetSeedLocation(seed, steps));


var locations = GetLocations(seeds);

Console.WriteLine(string.Join(",", seeds));
Console.WriteLine(string.Join(",", locations));
Console.WriteLine($"result 1: {locations.Min()}");

IEnumerable<long> GetlongRange(long start, long count)
{
    for (long i = start; i < start + count; i++)
    {
        yield return i;
    }
}

var part2Seeds = Enumerable.Zip(
    seeds.Where((item, index) => index % 2 == 0),
    seeds.Where((item, index) => index % 2 == 1)
    );
// get the location of each seend range and flatten
// var part2PrunedSeeds = part2Seeds.SelectMany(seedRange => GetlongRange(seedRange.First, seedRange.Second)).Distinct().AsParallel().ToList();
// var part2Locations = GetLocations(part2PrunedSeeds);
// Console.WriteLine($"result 2: {part2Locations.Min()}");

// long min = long.MaxValue;
// foreach (var (start, count) in part2Seeds)
// {
//     Console.WriteLine($"start {start}, count {count}");
//     for (long i = start; i < start + count; i++)
//     {
//         min = Math.Min(min, GetSeedLocation(i, steps));
//     }
//     Console.WriteLine($"Current min {min}");
// }
// Console.WriteLine($"result 2: {min}");

RangeMatch GetRangeIntersection2((long, long) a, (long, long) b)
{
    long aEnd = a.Item1 + a.Item2;
    long bEnd = b.Item1 + b.Item2;
    long maxOfStart = Math.Max(a.Item1, b.Item1);
    long minOfEnd = Math.Min(aEnd, bEnd);
    // no intersection if the start is greater than the end
    if (maxOfStart >= minOfEnd)
    {
        return new(null, [a]);
    }
    (long, long)[] nonMatches = [];
    if (a.Item1 < maxOfStart)
    {
        nonMatches = [.. nonMatches, (a.Item1, maxOfStart - a.Item1)];
    }
    if (aEnd > minOfEnd)
    {
        nonMatches = [.. nonMatches, (minOfEnd, aEnd - minOfEnd)];
    }
    return new((maxOfStart, minOfEnd - maxOfStart), nonMatches);
}

(long, long)[] GetOutputRanges((long, long) a, long[][] stepLines)
{
    (long, long)[] toTestRanges = [a];
    (long, long)[] outputRanges = [];

    foreach (var line in stepLines)
    {
        (long, long)[] nonMatchesAfterTesting = [];
        foreach (var toTestRange in toTestRanges)
        {
            var (match, currentNonMatches) = GetRangeIntersection2(toTestRange, (line[1], line[2]));
            if (match is (long, long) m)
            {
                var startDelta = m.Item1 > line[1] ? toTestRange.Item1 - line[1] : 0;
                outputRanges = [.. outputRanges, (line[0] + startDelta, m.Item2)];
            }
            nonMatchesAfterTesting = currentNonMatches;
        }
        toTestRanges = [.. nonMatchesAfterTesting];
    }
    return [.. outputRanges, .. toTestRanges];
}


(long, long)[] GetOutputRangesOfRanges((long, long)[] inputRanges, long[][] stepLines)
{
    (long, long)[] outputs = [];
    foreach (var inputRange in inputRanges)
    {
        outputs = [.. outputs, .. GetOutputRanges(inputRange, stepLines)];
    }
    return outputs;
}

var inputRanges1 = seeds.Select(seed => (seed, 1L)).ToArray();
foreach (var stepLines in steps)
{
    inputRanges1 = GetOutputRangesOfRanges(inputRanges1, stepLines);
}

Console.WriteLine($"result 1 bis: {inputRanges1.Min(item => item.seed)}");

var inputRanges = part2Seeds.ToArray();
foreach (var stepLines in steps)
{
    inputRanges = GetOutputRangesOfRanges(inputRanges, stepLines);
}

Console.WriteLine($"result 2: {inputRanges.Min(item => item.First)}");
