using System.Drawing;
using day10;

Dictionary<(Direction, char), Direction> possibleMoves = new(){
    {(Direction.Left, '-'), Direction.Left},
    {(Direction.Right, '-'), Direction.Right},
    {(Direction.Up, '|'), Direction.Down},
    {(Direction.Down, '|'), Direction.Up},
    {(Direction.Left, 'F'), Direction.Down},
    {(Direction.Up, 'F'), Direction.Right},
    {(Direction.Right, 'J'), Direction.Up},
    {(Direction.Down, 'J'), Direction.Left},
    {(Direction.Down, 'L'), Direction.Right},
    {(Direction.Left, 'L'), Direction.Up},
    {(Direction.Up, '7'), Direction.Left},
    {(Direction.Right, '7'), Direction.Down},
};

Dictionary<Direction, Point> positionShifts = new(){
    {Direction.Right, new(1, 0)},
    {Direction.Left, new(-1, 0)},
    {Direction.Up, new(0, -1)},
    {Direction.Down, new(0, 1)},
};

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

char getCharAfterMove(string[] lines, Direction direction, Point startPoint)
{
    startPoint.Offset(positionShifts[direction]);
    return lines[startPoint.X][startPoint.Y];
}

int RunStep1(string input)
{
    var lines = input.Split("\n");
    var startPoint = FindStart(lines);
    var currentDirection = Enum.GetValues<Direction>().Where(d =>
    {
        var c = getCharAfterMove(lines, d, startPoint);
        return possibleMoves.ContainsKey((d, c));
    });
    Point currentPoint = new(startPoint.X, startPoint.Y);
    currentPoint.Offset(positionShifts[currentDirection]);
    while (lines[currentPoint.X][currentPoint.Y] != "S")
    {
        var c = getCharAfterMove(lines, currentDirection, currentPoint);
        var direction =
    }
}


Console.WriteLine("step 1");
Console.WriteLine($"test 1. expexted: 4, actual: {runStep1(InputData.TestInput1)}");
Console.WriteLine($"test 2. expexted: 8, actual: {runStep1(InputData.TestInput2)}");
Console.WriteLine($"Puzzle Input. Actual: {runStep1(InputData.TestInput1)}");