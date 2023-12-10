using System.Drawing;
using day10;

static Point FindStart(string[] lines)
{
    for (int i = 0; i < lines.Length; i++)
    {
        var line = lines[i];
        for (int j = 0; j < line.Length; j++)
        {
            if (line[j] == 'S')
            {
                return new(i, j);
            }
        }
    }
    return new();
}

static int RunStep1(string input)
{
    var lines = input.Split("\n");
    var startPoint = FindStart(lines);

}


Console.WriteLine("step 1");
Console.WriteLine($"test 1. expexted: 4, actual: {runStep1(InputData.TestInput1)}");
Console.WriteLine($"test 2. expexted: 8, actual: {runStep1(InputData.TestInput2)}");
Console.WriteLine($"Puzzle Input. Actual: {runStep1(InputData.TestInput1)}");