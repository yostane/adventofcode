// Put sample inputs here
// looping obstables (6,3), (7,6), (7,7), (8,1), (8,3), (9,7)
val sampleInputs = listOf(
    """
....#.....
.........#
..........
..#.......
.......#..
..........
.#..^.....
........#.
#.........
......#...
""".trimIndent()
)

// Put the puzzle input here
val input = """
................................##..........................................................................#.......#.............
...#.......................................................................................................#......................
.#.....................#.............................................#................#..................#...#..#.#..#...#........
.#........................#....#.#.#..........................................#...............................................#...
..................#.......................................................#.......#.............#.................................
........................................#...................................#.........#......#...............#......#......#......
......#...#.......#..............#.....#..#....................#.................................................#......#.........
......................#...................#....#....................................#.#........................#.........#...#....
....................#..........................................................................................#..................
..#.........................#.............#...............#.......................................................................
.#...............................#...............................#...#................#.........#......................#..........
...#.....................................#.........#.............#...................#.......#........................#......#....
#...........................#............................#.............................#........................................#.
.........................#................#...........#..........................#.#..............................................
...........#.#.......#...#.............#.................................#............................................#...#.......
....#.......................#.......#..........#....................................#...............................#.#..#........
....#............#.......#.............................#..................#......#......#..............#.............#.....#.#....
...................................#..............#............#...#..............................................#...............
..............................#....#.#........#......................#...................#........#..#............................
....................................#.#....#.............................................#....#......#...................#........
..................##..................#........#.....#.........................................#.......#............#.............
.............#......................................................##...................................................#......#.
#......#................#.......................##...............#.....#.......................#..#.........#.............#...#...
.............................................................................................................#.....#..............
.......#..........#...............#.....##......#.......#.................#............#..........................................
.......#.............#.........................................................#................................................#.
...........#.......................#.....#...............#..............#........#.....#.........#.........................#......
.........#........#...............#................................................................#......#..........#............
..............#..................#...#...............................#.#.................................#.............#........#.
.....................#.......#..............................#........................#...........#....#.................#.......#.
..........#..................................#......#..#................##.........................................#..........#...
.....................#.....#.........#.....#...............#..........................................#.........................#.
..........#...#..............................#...................#.........#........................................#.............
.......#.........................................................................#..........#............#..#..........#..........
.....#..#..#...............#....................#..............#...........#.....#.....................#..........................
................................................#.............................................................................#...
................#.......................................................................................#.........................
.............#...#.......................#..................................................#....#................................
...............................#.......#.#.............................................#....................#....#................
......#....................................................#.......#......#.................................................#.....
...........................................................#..........................#.#.....#................#.................#
....#....#............#.........................#..#.........................#..................#......#...#.........##...........
...#..................#................................#......#.............#.#............................#......................
..........................#.............................................................................##........................
..............................................................................#.................#..........##.....................
....#.....................#.................#......................#...........#.........................................#........
..................................#..#....#.................................................................#............#.....#.#
.#.........................#.........................#....................#......................................#................
................##...........................#....................................................................................
.........#........................................#...........................#........#.........#.......#......#.......#...#...#.
.#..................................................................................#.........#..................................#
....#...............#..........................#.....#....................................................#.......................
.......................#.............................#......#...........^........#................................................
#.#..#.....#...................##..........#...................................................................................#..
..#....#.....................................................#...#.............#....#............#..#............................#
........................#..........#.....#............#...........#...............#............#....#.................#........#..
.................................#.............#...#..................#................................................#..........
...........#............................................................................#................#....................#...
..#.........#.............................#............................#....................#....................#................
.................................#..#................#................#...........................................................
.......................#.......................................#........................#................#......#...........#.....
#..............#.......#.........#...#.....#......#.....................#...#....#.......................................#........
.........#.#.............................#....#.......#..........................................................#................
...#............................................................................................#.................................
....................#...................#....................#..............#......#..#.............#.............................
...........#.....................................................##...............................................................
.....#......#...............................................................................#........#...................#........
..............................................#.............#....#................................................................
......................#.....................#........................................................#...#.........#..#.....#.....
..#...............................................................#..#....................#.#.....................................
............................................#...............#.....#.....#...#..#..................................................
.#...........................................................................#....................................................
.............................................................................................................#....................
#....................................................#..............##.......................................#....................
#..#....................#.......#...................................................................#...#.........................
..#........................................#............#...............................................................#.........
...............#...........................#...................#....#......#..................................#....#...........#.#
..........##........#.........................#.......#..#.........#...............#........#........#..........#.................
....##.......................................#...........#...................#......#.............................................
..............................#.........#............................#.............................................#..............
......#........#...........................#..................................#.....#.............................................
...............#.........#.....#.............#.............#...............#.#...............................................#....
........................................#...............................................................................##.#...#..
................#.......#.....#........................................................................#........................#.
....................................................................................#.........................................#...
........................................................................................#...#.....................................
........................#.#.........................................................................................#......#....##
......#.........................#.............#...................................................................................
................#...........................#..............#...#..........................#.......#......##.................#..#..
....................................................#.#.................................#....#....................................
#..................................#...............................................#......#.#.............#.......................
.....#..........#.....................................................................................#.#.......#............#....
..#.........................................................#...................#..................................#..###.#.....#.
...#.#..........#.........#..#......................#..##...#.......#..#.#.#...............#.....#....#...........................
...........#.....#...........#........................................................#..................#........................
.................#........#.......#...................#...#.......#.....#........#..#.............................................
...............................................#.......................#..................#.......................................
....#...................#.#......#............#...................#..........#..##................................................
....#........................#...........................................................#..................#..#.............#....
............#...............................................#.....................................................................
.........#.......#...................#...........#...............#....................#................#...#..#.......#...........
...............#...........................................................................#.....................#................
.............#....#.........................................................#............#....#.#....#.....#..#................#..
..#...............#.........................................................#........##.....#...#.........................#.......
..........................#.....................................#.................................#...............................
..#.............#...#...............................#.................................................................##..........
......#........#........................#..........................#..............................................#...............
......#.........................#..#.............................................................................................#
..................................................#..................#.....#...........#....#...#..........#................#.....
....#.....................................#..........#.....#......#..........#....................................................
...............................#...#...###.#.............................................................#...................#....
...#...................................#.....#...#....................#........................#..#.......................#......#
....#...#........#...................#..........#......................................#............#.............................
#.................................#.....................#.................#................#...#.#................................
.................................#.......#...........#..#...#......#.......#.........................#............................
.......................................##..........................#..................................................#...........
......#............#.##.........#...............#..........#....#.......................................#..#.................#....
.....#............................#.....#..................................................#.......#......................#.......
.............#.......................................................#...#...#....#...................#...........................
......#.................#.#................................#..#...............#.............................#....#...........#....
...............#...##......#.............................#.......................................#................................
#..................................................#.........#....#....#.....#...................#.#....#.....#...................
......#...#...##.................................................................#............................#...............#...
.#..................................#.#...............#................................#...#......................................
.........#.......#...#.......................#..................................................#.#................#..............
..................#............................#.....#.....#........#.....................#........................#.......#..#...
..#.............................#.............#.#................................................#.#.##....................#......
.......#.#......................#.#.....................................................##.............#..........................
..............#...#........................#................................#.........#.......................#..........#........
.......................#...............................#..#.........#.............................................................
""".trimIndent()