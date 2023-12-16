using System.Drawing;
using System.Reflection.PortableExecutable;
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

List<Point> getLoopPoints(string[] lines)
{
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
        // Console.WriteLine($"Current element {lines[currentPoint.X][currentPoint.Y]} {currentDirection}, {currentPoint}");
        moves += 1;
        loopPoints.Add(new Point(currentPoint.X, currentPoint.Y));
    }
    return loopPoints;
}

int RunStep1(string input)
{
    var lines = input.Split("\n");
    return getLoopPoints(lines).Count / 2;
}

(int, IEnumerable<Point>) countDotsInLine(string line, IEnumerable<Point> points)
{
    var isCurrentPointInsideLoop = true;
    var lastPoint = points.Last();
    var count = 0;
    List<Point> flaggedPoints = [];
    for (int col = points.First().Y + 1; col < lastPoint.Y; col++)
    {
        var c = line[col];
        Point currentPoint = new(points.Last().X, col);
        var isCurrentPointInPoints = points.Contains(currentPoint);
        if ((!isCurrentPointInsideLoop && !isCurrentPointInPoints) || (isCurrentPointInsideLoop && new int[] { '-', 'L', 'F' }.Contains(c) && isCurrentPointInPoints))
        {
            continue;
        }
        if (isCurrentPointInPoints)
        {
            isCurrentPointInsideLoop = !isCurrentPointInsideLoop;
        }
        else if (isCurrentPointInsideLoop)
        {
            count += 1;
            flaggedPoints.Add(currentPoint);
        }
    }
    return (count, flaggedPoints);
}

int countDotsInColmun(string[] charMatrix, IEnumerable<Point> columnPoints, IEnumerable<Point> taggedPoints)
{
    var isCurrentPointInsideLoop = true;
    var lastPoint = columnPoints.Last();
    var count = 0;
    for (int i = columnPoints.First().X + 1; i < lastPoint.X; i++)
    {
        var c = charMatrix[i][columnPoints.First().Y];
        Point currentPoint = new(i, columnPoints.First().Y);
        var isCurrentPointInPoints = columnPoints.Contains(currentPoint);
        if ((!isCurrentPointInsideLoop && !isCurrentPointInPoints) || (isCurrentPointInsideLoop && new int[] { '|', 'J', 'L' }.Contains(c) && isCurrentPointInPoints))
        {
            continue;
        }
        if (isCurrentPointInPoints)
        {
            isCurrentPointInsideLoop = !isCurrentPointInsideLoop;
        }
        else if (isCurrentPointInsideLoop && !taggedPoints.Contains(currentPoint))
        {
            count += 1;
        }
    }
    return count;
}


int RunStep2(string input)
{
    var lines = input.Split("\n");
    var loopPoints = getLoopPoints(lines);
    var loopLines = loopPoints.GroupBy(p => p.X).Select(g => g.OrderBy(p => p.Y)).OrderBy(g => g.First().X);
    var loopColumns = loopPoints.GroupBy(p => p.Y).Select(g => g.OrderBy(p => p.X)).OrderBy(g => g.First().Y);
    var res1 = loopLines.Select(loopLine => countDotsInLine(lines[loopLine.First().X], loopLine))
    .Aggregate((0, new List<Point>()), (acc, cur) =>
    {
        acc.Item1 += cur.Item1;
        acc.Item2.AddRange(acc.Item2);
        return acc;
    });
    return loopColumns.Select(columnPoints => countDotsInColmun(lines, columnPoints, res1.Item2)).Sum() + res1.Item1;
}

TileStatus markTileAndSurrounding(int i, int j, TileStatus[][] tiles, string[] inputMatrix, int minLine, int maxLine, int minColumn, int maxColumn, IEnumerable<Point> loopPoints, Dictionary<Direction, TileStatus> alreadyMarkedDirections)
{
    if (tiles[i][j] != TileStatus.Unknown)
    {
        return tiles[i][j];
    }
    if (i <= minLine || i > maxLine || j <= minColumn || j > maxColumn)
    {
        tiles[i][j] = TileStatus.NotEnclosedByLoop;
        return TileStatus.NotEnclosedByLoop;
    }
    tiles[i][j] = TileStatus.Marking;
    if (tiles[i - 1][j] == TileStatus.NotEnclosedByLoop)
    {
        tiles[i][j] = TileStatus.NotEnclosedByLoop;
        return TileStatus.NotEnclosedByLoop;
    }
    if (tiles[i - 1][j] == TileStatus.Loop)
    {
        if (inputMatrix[i + minLine - 1][j + minColumn] == 'J')
        {

        }
    }
    if (!alreadyMarkedDirections.ContainsKey(Direction.Up) && tiles[i - 1][j] != TileStatus.Unknown)
    {
        markTileAndSurrounding(i - 1, j, tiles, inputMatrix, minLine, maxLine, minColumn, maxColumn, loopPoints, alreadyMarkedDirections);
    }

    markTileAndSurrounding(i + 1, j, tiles, inputMatrix, minLine, maxLine, minColumn, maxColumn, loopPoints);
    markTileAndSurrounding(i, j - 1, tiles, inputMatrix, minLine, maxLine, minColumn, maxColumn, loopPoints);
    markTileAndSurrounding(i, j + 1, tiles, inputMatrix, minLine, maxLine, minColumn, maxColumn, loopPoints);
}

TileStatus[][] markTiles(int minLine, int maxLine, int minColumn, int maxColumn, IEnumerable<Point> loopPoints)
{
    TileStatus[][] tiles = new TileStatus[maxLine - minLine][];
    for (int i = 0; i < tiles.Length; i++)
    {
        tiles[i] = new TileStatus[maxColumn - minColumn];
        Array.Fill(tiles[i], TileStatus.Unknown);
        for (int j = 0; j < tiles[i].Length; j++)
        {
            if (loopPoints.Contains(new(i + minLine, j + maxColumn)))
            {
                tiles[i][j] = TileStatus.Loop;
            }
        }
    }
    for (int i = 0; i < tiles.Length; i++)
    {
        for (int j = 0; j < tiles[i].Length; j++)
        {
            if (tiles[i][j] == TileStatus.Unknown)
            {

            }
        }
    }
    return tiles;
}

int RunStep2B(string input)
{
    var lines = input.Split("\n");
    var loopPoints = getLoopPoints(lines);
}



// Console.WriteLine("step 1");
// Console.WriteLine($"test 1. expexted: 4, actual: {RunStep1(InputData.TestInput1)}");
// Console.WriteLine($"test 2. expexted: 8, actual: {RunStep1(InputData.TestInput2)}");
// Console.WriteLine($"Puzzle Input. Actual: {RunStep1(InputData.PuzzleInput)}");

Console.WriteLine("step 2");
Console.WriteLine($"test 1. expexted: 1, actual: {RunStep2(InputData.TestInput1)}");
Console.WriteLine($"test 2. expexted: 0, actual: {RunStep2(InputData.TestInput2)}");
Console.WriteLine($"test 3. expexted: 4, actual: {RunStep2(InputData.TestInput3)}");
Console.WriteLine($"test 4. expexted: 8, actual: {RunStep2(InputData.TestInput4)}");
Console.WriteLine($"test 5. expexted: 10, actual: {RunStep2(InputData.TestInput5)}");
Console.WriteLine($"Puzzle Input. Actual: {RunStep2(InputData.PuzzleInput)}");
