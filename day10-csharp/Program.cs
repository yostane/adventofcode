using System.Drawing;
using System.Text.RegularExpressions;
using day10;

Dictionary<(Direction, char), Direction> possibleMoves = new(){
    {(Direction.Left, '-'), Direction.Left},
    {(Direction.Right, '-'), Direction.Right},
    {(Direction.Up, '|'), Direction.Up},
    {(Direction.Down, '|'), Direction.Down},
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
    {Direction.Right, new(0, 1)},
    {Direction.Left, new(0, -1)},
    {Direction.Up, new(-1, 0)},
    {Direction.Down, new(1, 0)},
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
    var p = new Point(startPoint.X, startPoint.Y);
    p.Offset(positionShifts[direction]);
    if (p.X < 0 || p.X >= lines.Length || p.Y < 0 || p.Y >= lines[p.X].Length)
    {
        return '*';
    }
    return lines[p.X][p.Y];
}

List<Point> getLoopPoints(string input)
{
    var lines = input.Split("\n");
    var startPoint = FindStart(lines);
    var currentDirection = Enum.GetValues<Direction>().First(d =>
    {
        var c = getCharAfterMove(lines, d, startPoint);
        return possibleMoves.ContainsKey((d, c));
    });
    var moves = 1;
    Point currentPoint = new(startPoint.X, startPoint.Y);
    currentPoint.Offset(positionShifts[currentDirection]);
    List<Point> loopPoints = [new Point(currentPoint.X, currentPoint.Y)];
    while (lines[currentPoint.X][currentPoint.Y] != 'S')
    {
        currentDirection = possibleMoves[(currentDirection, lines[currentPoint.X][currentPoint.Y])];
        currentPoint.Offset(positionShifts[currentDirection]);
        Console.WriteLine($"Current element {lines[currentPoint.X][currentPoint.Y]} {currentDirection}, {currentPoint}");
        moves += 1;
        loopPoints.Add(new Point(currentPoint.X, currentPoint.Y));
    }
    return loopPoints;
}

int RunStep1(string input)
{
    return getLoopPoints(input).Count / 2;
}

int countDotsInLine(string[] lines, IEnumerable<Point> points)
{
    var isInsideLoop = true;
    points = points.Skip(1);
    var lastPoint = points.Last();
    for (int i = 0; i < lastPoint.X; i++)
    {
        var c = lines[i][lastPoint.Y];
        if (c == '-' && points.Contains(new(i, lastPoint.Y))) ;
        {
            continue;
        }
        if (isInsideLoop)
        {

        }
    }
}

int RunStep2(string input, List<Point> loopPoints)
{
    var lines = loopPoints.GroupBy(p => p.Y).Select(g => g.OrderBy(p => p.X)).OrderBy(g => g.First().Y);
    foreach (var linePoints in lines)
    {

    }
    return 0;
}


Console.WriteLine("step 1");
Console.WriteLine($"test 1. expexted: 4, actual: {RunStep1(InputData.TestInput1)}");
Console.WriteLine($"test 2. expexted: 8, actual: {RunStep1(InputData.TestInput2)}");
Console.WriteLine($"Puzzle Input. Actual: {RunStep1(InputData.PuzzleInput)}");