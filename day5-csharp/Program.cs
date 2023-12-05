using AdvenOfCode2023;

// const string input = InputData.testInput;
const string input = InputData.input;

string[] parts = input.Split(Environment.NewLine + Environment.NewLine);

var seeds = parts[0]["seeds: ".Length..].Split(" ").Select(long.Parse).ToList();

var stringSteps = parts[1..].Select(part => part.Split($":{Environment.NewLine}")[1]);

long[][] ConvertStepToMatrix(string step) => step.Split(Environment.NewLine).Select(
        line => line.Split(" ").Select(long.Parse).ToArray()
        ).ToArray();

var steps = stringSteps.Select(ConvertStepToMatrix).ToArray();

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

var locations = seeds.Select(seed =>
{
    long output = seed;
    foreach (var step in steps)
    {
        output = GetStepOutput(output, step);
    }
    return output;
});

Console.WriteLine(string.Join(",", seeds));
Console.WriteLine(string.Join(",", locations));
Console.WriteLine($"result: {locations.Min()}");