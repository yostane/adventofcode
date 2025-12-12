using System.Net.Mail;

int convertCharDigitToInt(char c) => c - '0';
long getMax2digJolts(string bank, int startIndex)
{
    char d2 = bank[startIndex];
    char d1 = bank[(startIndex + 1)..].Max();
    long v = convertCharDigitToInt(d2) * 10 + convertCharDigitToInt(d1);
    return v;
}

long runPart1(string input)
{
    var lines = input.Split('\n');
    return lines.Sum(line =>
    {
        long bankMax = Enumerable.Range(0, line.Length - 1).Max(i => getMax2digJolts(line, i));
        return bankMax;
    });
}

long getMax12digJolts(string bank, int startIndex)
{
    int subStart = startIndex;
    long result = 0;
    for (int i = 11; i >= 0; i--)
    {
        int subEnd = bank.Length - i - 1;
        int count = subEnd - subStart + 1;
        var range = Enumerable.Range(subStart, count);
        int maxIndex = range.MaxBy(j => bank.ElementAt(j));
        char d = bank[maxIndex];
        result += convertCharDigitToInt(d) * (long)Math.Pow(10, i);
        subStart = maxIndex + 1;
    }
    return result;
}

long runPart2(string input)
{
    var lines = input.Split('\n');
    return lines.Sum(line =>
    {
        long bankMax = Enumerable.Range(0, line.Length - 12).Max(i => getMax12digJolts(line, i));
        return bankMax;
    });
}

Console.WriteLine("Test inputs");
foreach (var testInput in Inputs.testInputs)
{
    Console.WriteLine($"Test input: {testInput}");
    var result1 = runPart1(testInput);
    Console.WriteLine($"Part 1: {result1}");
    var result2 = runPart2(testInput);
    Console.WriteLine($"Part 2: {result2}");
}

Console.WriteLine("Puzzle input");
var puzzleResult1 = runPart1(Inputs.puzzleInput);
Console.WriteLine($"Part 1: {puzzleResult1}");
var puzzleResult2 = runPart2(Inputs.puzzleInput);
Console.WriteLine($"Part 2: {puzzleResult2}");