namespace day10
{
    public enum Direction
    {
        Left, Up, Right, Down
    }

    public enum TileStatus
    {
        Unknown, Marking, Loop, EnclosedByLoop, NotEnclosedByLoop
    }
}