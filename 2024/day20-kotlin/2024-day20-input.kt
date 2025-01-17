// Put sample inputs here
val sampleInputs = listOf(
    """
    ###############
    #...#...#.....#
    #.#.#.#.#.###.#
    #S#...#.#.#...#
    #######.#.#.###
    #######.#.#...#
    #######.#.###.#
    ###..E#...#...#
    ###.#######.###
    #...###...#...#
    #.#####.#.###.#
    #.#...#.#.#...#
    #.#.#.#.#.#.###
    #...#...#...###
    ###############""".trimIndent()
)

// Put the puzzle input here
val input = """
    #############################################################################################################################################
    ###...#.....#...###...#...###...###.....#...............#...###...#...###.......#...#...........#...#.....#.....#...#...#.....#.......###...#
    ###.#.#.###.#.#.###.#.#.#.###.#.###.###.#.#############.#.#.###.#.#.#.###.#####.#.#.#.#########.#.#.#.###.#.###.#.#.#.#.#.###.#.#####.###.#.#
    #...#...#...#.#.#...#...#.#...#...#.#...#.........#...#.#.#.....#...#.#...#.....#.#.#.....#.....#.#.#.#...#.#...#.#.#.#.#...#...#.....#...#.#
    #.#######.###.#.#.#######.#.#####.#.#.###########.#.#.#.#.###########.#.###.#####.#.#####.#.#####.#.#.#.###.#.###.#.#.#.###.#####.#####.###.#
    #.......#...#.#.#.#.......#.....#.#.#.......#...#...#.#...#.....#...#.#.#...###...#...#...#...#...#.#.#.#...#...#.#.#.#.###...#...#...#...#.#
    #######.###.#.#.#.#.###########.#.#.#######.#.#.#####.#####.###.#.#.#.#.#.#####.#####.#.#####.#.###.#.#.#.#####.#.#.#.#.#####.#.###.#.###.#.#
    ###...#...#...#...#.....###...#.#...#.......#.#.#...#.....#.###...#.#.#.#.....#.....#.#...#...#...#...#.#.#...#.#.#.#.#...#...#.###.#.#...#.#
    ###.#.###.#############.###.#.#.#####.#######.#.#.#.#####.#.#######.#.#.#####.#####.#.###.#.#####.#####.#.#.#.#.#.#.#.###.#.###.###.#.#.###.#
    #...#.###...........#...#...#.#.#...#.....#...#...#.#...#...#...#...#.#.#.....#.....#.#...#.....#.#.....#...#.#...#.#.#...#...#...#.#.#.#...#
    #.###.#############.#.###.###.#.#.#.#####.#.#######.#.#.#####.#.#.###.#.#.#####.#####.#.#######.#.#.#########.#####.#.#.#####.###.#.#.#.#.###
    #.#...#...###.......#...#.#...#.#.#.#.....#.....#...#.#.###...#...#...#.#.#...#.....#.#...#.....#.#.......#...#...#...#.....#...#.#.#.#.#...#
    #.#.###.#.###.#########.#.#.###.#.#.#.#########.#.###.#.###.#######.###.#.#.#.#####.#.###.#.#####.#######.#.###.#.#########.###.#.#.#.#.###.#
    #.#.....#...#.........#.#.#.###.#.#...#.......#.#...#.#...#.......#.....#.#.#.#...#.#.#...#.....#.#.......#.....#.#.........#...#...#.#...#.#
    #.#########.#########.#.#.#.###.#.#####.#####.#.###.#.###.#######.#######.#.#.#.#.#.#.#.#######.#.#.#############.#.#########.#######.###.#.#
    #.......#...#...#...#.#.#.#.#...#.#...#.....#.#.#...#...#...#...#...#.....#.#.#.#.#.#.#.#.......#.#.#...###...#...#.......###...#...#.....#.#
    #######.#.###.#.#.#.#.#.#.#.#.###.#.#.#####.#.#.#.#####.###.#.#.###.#.#####.#.#.#.#.#.#.#.#######.#.#.#.###.#.#.#########.#####.#.#.#######.#
    ###...#.#.#...#.#.#.#.#.#.#.#...#...#...#...#.#.#.#...#...#...#.....#.#...#.#.#.#.#.#...#.#.......#...#...#.#.#...#...#...#...#.#.#.....#...#
    ###.#.#.#.#.###.#.#.#.#.#.#.###.#######.#.###.#.#.#.#.###.###########.#.#.#.#.#.#.#.#####.#.#############.#.#.###.#.#.#.###.#.#.#.#####.#.###
    #...#.#.#.#...#.#.#...#...#.#...#.......#.#...#.#.#.#...#.#...#.....#...#.#.#...#.#.#.....#.#...........#.#.#.....#.#...#...#.#.#.....#...###
    #.###.#.#.###.#.#.#########.#.###.#######.#.###.#.#.###.#.#.#.#.###.#####.#.#####.#.#.#####.#.#########.#.#.#######.#####.###.#.#####.#######
    #...#.#.#.....#.#.........#.#...#.###.....#...#.#.#.#...#...#...###...#...#.....#...#...#...#.......#...#.#.......#...###...#.#.#.....#...###
    ###.#.#.#######.#########.#.###.#.###.#######.#.#.#.#.###############.#.#######.#######.#.#########.#.###.#######.###.#####.#.#.#.#####.#.###
    #...#...#.....#.#...#...#.#.###.#...#...#.....#.#.#.#.....###...#...#.#...#.....#.......#...#.......#.....#...#...#...#...#.#...#.......#...#
    #.#######.###.#.#.#.#.#.#.#.###.###.###.#.#####.#.#.#####.###.#.#.#.#.###.#.#####.#########.#.#############.#.#.###.###.#.#.###############.#
    #...#.....###.#...#...#...#.....#...#...#...#...#...#.....#...#.#.#.#.#...#.....#...#...#...#.#...#...###...#.#...#...#.#.#.....#...........#
    ###.#.#######.###################.###.#####.#.#######.#####.###.#.#.#.#.#######.###.#.#.#.###.#.#.#.#.###.###.###.###.#.#.#####.#.###########
    ###...#.......#.........#...#...#...#.#.....#...#.....#...#...#...#.#.#...#.....#...#.#.#.#...#.#.#.#...#...#.....#...#.#...#...#...#...#...#
    #######.#######.#######.#.#.#.#.###.#.#.#######.#.#####.#.###.#####.#.###.#.#####.###.#.#.#.###.#.#.###.###.#######.###.###.#.#####.#.#.#.#.#
    #...###.#...#...#.......#.#...#...#.#.#.###...#.#.#...#.#...#.....#.#.#...#.....#.....#.#.#...#.#.#.#...###...#.....#...#...#.#.....#.#.#.#.#
    #.#.###.#.#.#.###.#######.#######.#.#.#.###.#.#.#.#.#.#.###.#####.#.#.#.#######.#######.#.###.#.#.#.#.#######.#.#####.###.###.#.#####.#.#.#.#
    #.#...#...#...###...#.....#.......#.#.#.#...#...#.#.#.#.#...###...#.#.#.#.....#.....#...#...#...#.#.#.#...#...#.......#...#...#.......#...#.#
    #.###.#############.#.#####.#######.#.#.#.#######.#.#.#.#.#####.###.#.#.#.###.#####.#.#####.#####.#.#.#.#.#.###########.###.###############.#
    #...#...###...#...#...#...#...#...#.#.#.#...#.....#.#.#.#.#...#.#...#.#.#.#...#...#.#.#...#...#...#.#.#.#.#.#...........#...#...#...#...#...#
    ###.###.###.#.#.#.#####.#.###.#.#.#.#.#.###.#.#####.#.#.#.#.#.#.#.###.#.#.#.###.#.#.#.#.#.###.#.###.#.#.#.#.#.###########.###.#.#.#.#.#.#.###
    #...#...#...#...#.#.....#...#...#.#...#.....#...#...#.#.#.#.#.#.#.....#...#.#...#.#.#.#.#.#...#.#...#...#...#...#...###...#...#.#.#.#.#...###
    #.###.###.#######.#.#######.#####.#############.#.###.#.#.#.#.#.###########.#.###.#.#.#.#.#.###.#.#############.#.#.###.###.###.#.#.#.#######
    #...#...#.......#.#.......#.#...#...........#...#.#...#.#...#.#...#.........#.###.#.#...#.#...#...#.....#.......#.#.#...#...###...#...#...###
    ###.###.#######.#.#######.#.#.#.###########.#.###.#.###.#####.###.#.#########.###.#.#####.###.#####.###.#.#######.#.#.###.#############.#.###
    ###...#.#.......#.........#...#.............#.#...#.#...#...#.#...#.........#...#.#.#.....#...#...#...#...###...#.#.#.#...###...........#...#
    #####.#.#.###################################.#.###.#.###.#.#.#.###########.###.#.#.#.#####.###.#.###.#######.#.#.#.#.#.#####.#############.#
    #.....#...#.....#...........................#.#.#...#.#...#...#.........###...#.#...#.#.....###.#...#.........#...#...#.....#.#...........#.#
    #.#########.###.#.#########################.#.#.#.###.#.###############.#####.#.#####.#.#######.###.#######################.#.#.#########.#.#
    #.#...#...#.#...#.#...........#...#.....#...#...#...#.#...#...#.......#.#.....#.....#.#.#.....#...#...............#...#...#...#.#.......#...#
    #.#.#.#.#.#.#.###.#.#########.#.#.#.###.#.#########.#.###.#.#.#.#####.#.#.#########.#.#.#.###.###.###############.#.#.#.#.#####.#.#####.#####
    #...#...#...#.....#...#.....#.#.#.#...#.#...###...#.#.#...#.#.#.....#...#.....#...#.#...#...#.....#...........###...#.#.#.....#...#...#.....#
    #####################.#.###.#.#.#.###.#.###.###.#.#.#.#.###.#.#####.#########.#.#.#.#######.#######.#########.#######.#.#####.#####.#.#####.#
    #...#.....###...#...#...#...#...#.....#...#.#...#.#.#.#...#.#...#...###.......#.#...###...#...#...#.#.......#.....#...#.....#.......#.......#
    #.#.#.###.###.#.#.#.#####.###############.#.#.###.#.#.###.#.###.#.#####.#######.#######.#.###.#.#.#.#.#####.#####.#.#######.#################
    #.#.#...#.#...#...#.......#...#.....#...#...#...#.#...###.#.###.#.....#.......#.......#.#.###...#...#.#...#.#.....#.#.....#...#...#...#...###
    #.#.###.#.#.###############.#.#.###.#.#.#######.#.#######.#.###.#####.#######.#######.#.#.###########.#.#.#.#.#####.#.###.###.#.#.#.#.#.#.###
    #.#.#...#.#...#...#.......#.#...###...#.........#...###...#...#.#...#.###...#.#...#...#.#...........#...#.#.#.#...#...###...#...#...#...#...#
    #.#.#.###.###.#.#.#.#####.#.#######################.###.#####.#.#.#.#.###.#.#.#.#.#.###.###########.#####.#.#.#.#.#########.###############.#
    #.#.#.#...###...#...#...#...###.........#.........#.#...#...#.#...#.#...#.#...#.#.#.###...........#.......#...#.#.....#...#.#.......#...#...#
    #.#.#.#.#############.#.#######.#######.#.#######.#.#.###.#.#.#####.###.#.#####.#.#.#############.#############.#####.#.#.#.#.#####.#.#.#.###
    #.#...#...#...#...#...#.......#.......#...#.....#.#.#...#.#.#.#.....#...#.#...#.#.#.....###...###...............#.....#.#.#.#.....#...#...###
    #.#######.#.#.#.#.#.#########.#######.#####.###.#.#.###.#.#.#.#.#####.###.#.#.#.#.#####.###.#.###################.#####.#.#.#####.###########
    #...#...#.#.#.#.#.#.........#.#.......###...#...#...#...#.#...#...#...###.#.#.#.#.......#...#...#.................#...#.#.#.#...#.#.........#
    ###.#.#.#.#.#.#.#.#########.#.#.#########.###.#######.###.#######.#.#####.#.#.#.#########.#####.#.#################.#.#.#.#.#.#.#.#.#######.#
    #...#.#.#...#.#.#.#.........#...#...#...#...#.#...###...#.....###.#.....#.#.#.#.#.........#...#.#...................#...#.#.#.#.#...#...#...#
    #.###.#.#####.#.#.#.#############.#.#.#.###.#.#.#.#####.#####.###.#####.#.#.#.#.#.#########.#.#.#########################.#.#.#.#####.#.#.###
    #...#.#.....#...#.#.......#.....#.#...#.#...#...#...#...#...#.#...#...#.#.#.#.#.#.#...#...#.#.#.................#...#.....#...#.......#...###
    ###.#.#####.#####.#######.#.###.#.#####.#.#########.#.###.#.#.#.###.#.#.#.#.#.#.#.#.#.#.#.#.#.#################.#.#.#.#######################
    ###...###...#...#.......#...###...#...#.#.#.......#.#.....#.#.#.#...#...#.#.#...#...#...#...#...............###...#...###...........#...#...#
    #########.###.#.#######.###########.#.#.#.#.#####.#.#######.#.#.#.#######.#.###############################.#############.#########.#.#.#.#.#
    #...#.....#...#.......#.###...#.....#...#.#.#...#...#...###...#...#...###...###.............................#.......#...#.#.........#.#...#.#
    #.#.#.#####.#########.#.###.#.#.#########.#.#.#.#####.#.###########.#.#########.#############################.#####.#.#.#.#.#########.#####.#
    #.#...#.....#...###...#.....#...#.........#...#...#...#.#...###.....#.....#.....#.....#.....#...............#.#...#...#...#...#...#...#...#.#
    #.#####.#####.#.###.#############.###############.#.###.#.#.###.#########.#.#####.###.#.###.#.#############.#.#.#.###########.#.#.#.###.#.#.#
    #.#...#.#.....#.....#...#...#...#.#...............#.#...#.#.....#.........#.......###...###...#...#.........#.#.#...#...#...#.#.#.#.#...#...#
    #.#.#.#.#.###########.#.#.#.#.#.#.#.###############.#.###.#######.#############################.#.#.#########.#.###.#.#.#.#.#.#.#.#.#.#######
    #...#.#.#.#.........#.#...#...#...#.............###.#.....#######....E#...#...#...#.............#...#.........#...#.#.#.#.#.#...#...#.......#
    #####.#.#.#.#######.#.#########################.###.###################.#.#.#.#.#.#.#################.###########.#.#.#.#.#.###############.#
    ###...#.#.#.#.....#...###.................#S###.....###################.#.#.#...#.#...............#...###...#.....#...#...#...#.............#
    ###.###.#.#.#.###.#######.###############.#.###########################.#.#.#####.###############.#.#####.#.#.###############.#.#############
    #...#...#...#...#.###...#...#...#.......#.#.#######################...#.#.#.....#...............#...#.....#.#...........#.....#.............#
    #.###.#########.#.###.#.###.#.#.#.#####.#.#.#######################.#.#.#.#####.###############.#####.#####.###########.#.#################.#
    #.#...#...#.....#.#...#.###...#...#.....#...###########...#########.#.#.#.#...#...........#.....#...#.#...#.............#.....#...#...#...#.#
    #.#.###.#.#.#####.#.###.###########.###################.#.#########.#.#.#.#.#.###########.#.#####.#.#.#.#.###################.#.#.#.#.#.#.#.#
    #...###.#.#.....#.#...#.#...###...#.#.....#...#...#...#.#.....#.....#...#...#.......#.....#...#...#.#...#...........#...#...#.#.#.#.#.#.#...#
    #######.#.#####.#.###.#.#.#.###.#.#.#.###.#.#.#.#.#.#.#.#####.#.###################.#.#######.#.###.###############.#.#.#.#.#.#.#.#.#.#.#####
    ###...#.#.......#...#.#...#.....#...#.#...#.#.#.#...#.#.#.....#.........#.....#...#...#.....#.#...#.................#.#...#.#...#...#.#.....#
    ###.#.#.###########.#.###############.#.###.#.#.#####.#.#.#############.#.###.#.#.#####.###.#.###.###################.#####.#########.#####.#
    #...#...#...#.....#...#...............#.....#.#...#...#.#.......###...#...###...#.....#.#...#...#.........#...#...###.#.....#.......#...#...#
    #.#######.#.#.###.#####.#####################.###.#.###.#######.###.#.###############.#.#.#####.#########.#.#.#.#.###.#.#####.#####.###.#.###
    #.........#...###...#...###.............#.....#...#.....#.......#...#...###...#.....#.#.#.....#.#...#...#...#...#.....#.......#...#...#.#...#
    ###################.#.#####.###########.#.#####.#########.#######.#####.###.#.#.###.#.#.#####.#.#.#.#.#.#######################.#.###.#.###.#
    ###...#.......#####...#.....#.........#.#.......#.....#...#.....#.....#...#.#...#...#...###...#...#...#.....#...#...#...........#.#...#.....#
    ###.#.#.#####.#########.#####.#######.#.#########.###.#.###.###.#####.###.#.#####.#########.###############.#.#.#.#.#.###########.#.#########
    #...#.#.....#...###...#.....#.#.......#.#.....#...###...###...#...###...#.#...#...#...#...#.........#.....#...#...#...#...#...###.#...#...###
    #.###.#####.###.###.#.#####.#.#.#######.#.###.#.#############.###.#####.#.###.#.###.#.#.#.#########.#.###.#############.#.#.#.###.###.#.#.###
    #...#.....#...#.#...#.#...#...#.......#.#...#.#.........#...#.#...#.....#.#...#.#...#...#...#...###...###...........###.#...#...#...#...#...#
    ###.#####.###.#.#.###.#.#.###########.#.###.#.#########.#.#.#.#.###.#####.#.###.#.#########.#.#.###################.###.#######.###.#######.#
    #...#.....###.#.#...#...#...#...#.....#...#.#.#.........#.#...#...#.....#.#...#.#.#.......#...#.#.....###...#...#...#...#...#...###.#...#...#
    #.###.#######.#.###.#######.#.#.#.#######.#.#.#.#########.#######.#####.#.###.#.#.#.#####.#####.#.###.###.#.#.#.#.###.###.#.#.#####.#.#.#.###
    #...#.###...#.#.###.....#...#.#.#.......#...#...###...###...#...#.....#.#...#.#.#...#.....#.....#...#.....#...#...#...#...#...#...#...#.#...#
    ###.#.###.#.#.#.#######.#.###.#.#######.###########.#.#####.#.#.#####.#.###.#.#.#####.#####.#######.###############.###.#######.#.#####.###.#
    #...#.....#...#.........#.....#.......#.....#.......#...###...#...#...#.#...#.#.#.....#.....#.....#...#...........#...#.#...#...#...###...#.#
    #.###################################.#####.#.#########.#########.#.###.#.###.#.#.#####.#####.###.###.#.#########.###.#.#.#.#.#####.#####.#.#
    #.#...#.....#.........#...#...#.....#.......#.....#.....#...#...#.#.#...#...#.#.#.....#...###.#...###...#.........#...#...#...#...#.#...#...#
    #.#.#.#.###.#.#######.#.#.#.#.#.###.#############.#.#####.#.#.#.#.#.#.#####.#.#.#####.###.###.#.#########.#########.###########.#.#.#.#.#####
    #.#.#.#.###...#...#...#.#...#.#.#...#.....#...#...#.#.....#.#.#.#.#.#...#...#.#...#...#...#...#...#.....#.....#.....#.........#.#.#...#.....#
    #.#.#.#.#######.#.#.###.#####.#.#.###.###.#.#.#.###.#.#####.#.#.#.#.###.#.###.###.#.###.###.#####.#.###.#####.#.#####.#######.#.#.#########.#
    #.#.#.#.#.....#.#...#...#.....#.#...#...#.#.#.#.#...#...#...#.#.#.#.###.#.###...#.#.#...###...#...#...#.#...#...#...#.......#...#.........#.#
    #.#.#.#.#.###.#.#####.###.#####.###.###.#.#.#.#.#.#####.#.###.#.#.#.###.#.#####.#.#.#.#######.#.#####.#.#.#.#####.#.#######.#############.#.#
    #.#.#...#...#...#...#.#...#...#.#...#...#.#.#.#.#.#...#.#.#...#...#.#...#...#...#...#.#.....#.#...#...#.#.#.#...#.#.#.....#.#.........#...#.#
    #.#.#######.#####.#.#.#.###.#.#.#.###.###.#.#.#.#.#.#.#.#.#.#######.#.#####.#.#######.#.###.#.###.#.###.#.#.#.#.#.#.#.###.#.#.#######.#.###.#
    #...###...#.....#.#.#.#.#...#.#.#...#...#...#.#.#.#.#.#.#.#.....#...#.###...#.#.......#.#...#.#...#...#.#.#.#.#.#.#.#...#.#...#.......#.....#
    #######.#.#####.#.#.#.#.#.###.#.###.###.#####.#.#.#.#.#.#.#####.#.###.###.###.#.#######.#.###.#.#####.#.#.#.#.#.#.#.###.#.#####.#############
    #.......#.......#.#.#.#...#...#.###...#.....#.#.#...#.#.#.....#.#...#...#.....#...#...#.#...#.#.......#...#.#.#...#.#...#.......###.........#
    #.###############.#.#.#####.###.#####.#####.#.#.#####.#.#####.#.###.###.#########.#.#.#.###.#.#############.#.#####.#.#############.#######.#
    #.....#...#...#...#.#.....#...#.#.....#...#.#...###...#...#...#...#.#...#...#.....#.#.#.#...#.........#...#.#.....#...#...#.........#.......#
    #####.#.#.#.#.#.###.#####.###.#.#.#####.#.#.#######.#####.#.#####.#.#.###.#.#.#####.#.#.#.###########.#.#.#.#####.#####.#.#.#########.#######
    #.....#.#.#.#...#...#...#.#...#.#.....#.#...#.......#.....#.#...#.#.#.....#.#.#...#.#.#.#.#.........#...#.#.#...#.......#...#.......#.......#
    #.#####.#.#.#####.###.#.#.#.###.#####.#.#####.#######.#####.#.#.#.#.#######.#.#.#.#.#.#.#.#.#######.#####.#.#.#.#############.#####.#######.#
    #...#...#.#...###...#.#...#...#...###.#.....#...#...#.#.....#.#.#.#...#...#.#...#.#.#...#.#.......#...#...#...#.#...#...#...#.....#.........#
    ###.#.###.###.#####.#.#######.###.###.#####.###.#.#.#.#.#####.#.#.###.#.#.#.#####.#.#####.#######.###.#.#######.#.#.#.#.#.#.#####.###########
    #...#...#...#.#.....#.....#...#...#...#.....###.#.#.#.#.....#.#...#...#.#.#.#.....#.#.....#...#...#...#.......#...#.#.#...#.#...#...#.......#
    #.#####.###.#.#.#########.#.###.###.###.#######.#.#.#.#####.#.#####.###.#.#.#.#####.#.#####.#.#.###.#########.#####.#.#####.#.#.###.#.#####.#
    #.#.....###...#.....#.....#...#.#...#...#.......#.#.#.#.....#.....#...#.#...#.#...#.#...#...#.#...#...#.......#...#.#.#.....#.#...#...#...#.#
    #.#.###############.#.#######.#.#.###.###.#######.#.#.#.#########.###.#.#####.#.#.#.###.#.###.###.###.#.#######.#.#.#.#.#####.###.#####.#.#.#
    #.#...#...#.........#...#.....#.#.#...###.#...#...#.#.#.#...#...#...#.#.....#...#.#.#...#.###...#.#...#.......#.#...#.#...#...###...#...#...#
    #.###.#.#.#.###########.#.#####.#.#.#####.#.#.#.###.#.#.#.#.#.#.###.#.#####.#####.#.#.###.#####.#.#.#########.#.#####.###.#.#######.#.#######
    #...#...#.#.#.....#...#.#.#.....#.#.#...#...#.#.#...#.#...#.#.#...#.#...#...#.....#.#...#.....#...#.#...#.....#...#...#...#.###...#.#.......#
    ###.#####.#.#.###.#.#.#.#.#.#####.#.#.#.#####.#.#.###.#####.#.###.#.###.#.###.#####.###.#####.#####.#.#.#.#######.#.###.###.###.#.#.#######.#
    #...#.....#.#...#.#.#.#.#...#.....#...#...###...#.....#.....#.#...#...#...###.......#...#...#.....#...#.#.......#.#...#...#.....#.#.#...#...#
    #.###.#####.###.#.#.#.#.#####.###########.#############.#####.#.#####.###############.###.#.#####.#####.#######.#.###.###.#######.#.#.#.#.###
    #...#.....#.#...#.#.#...#...#.....#.......#.....#.......#...#.#...#...###...#...#...#.#...#.#...#.....#...#...#.#.#...#...#.......#.#.#.#...#
    ###.#####.#.#.###.#.#####.#.#####.#.#######.###.#.#######.#.#.###.#.#####.#.#.#.#.#.#.#.###.#.#.#####.###.#.#.#.#.#.###.###.#######.#.#.###.#
    ###.#...#.#.#.###.#.#.....#.......#.........#...#...#...#.#.#...#.#.#.....#...#...#...#.#...#.#.#...#...#.#.#...#.#.#...#...#...#...#.#...#.#
    ###.#.#.#.#.#.###.#.#.#######################.#####.#.#.#.#.###.#.#.#.#################.#.###.#.#.#.###.#.#.#####.#.#.###.###.#.#.###.###.#.#
    #...#.#.#.#.#.#...#.#.......#.......#.......#...###.#.#.#.#...#.#.#.#.....#...#.....#...#...#.#.#.#.#...#.#...#...#.#...#.....#.#...#...#.#.#
    #.###.#.#.#.#.#.###.#######.#.#####.#.#####.###.###.#.#.#.###.#.#.#.#####.#.#.#.###.#.#####.#.#.#.#.#.###.###.#.###.###.#######.###.###.#.#.#
    #.#...#.#.#.#.#.#...###.....#.#.....#.....#.#...#...#.#.#.#...#.#.#.....#...#.#...#.#...#...#.#.#.#.#...#...#.#.#...###...#...#.###.#...#.#.#
    #.#.###.#.#.#.#.#.#####.#####.#.#########.#.#.###.###.#.#.#.###.#.#####.#####.###.#.###.#.###.#.#.#.###.###.#.#.#.#######.#.#.#.###.#.###.#.#
    #.#...#.#.#.#.#.#.#.....#.....#.......#...#.#.###...#.#...#.....#.#...#.....#.#...#.#...#...#.#.#.#.#...#...#.#.#...###...#.#.#...#.#...#...#
    #.###.#.#.#.#.#.#.#.#####.###########.#.###.#.#####.#.###########.#.#.#####.#.#.###.#.#####.#.#.#.#.#.###.###.#.###.###.###.#.###.#.###.#####
    #.#...#.#.#.#.#.#.#.#...#.#...........#...#.#.....#.#...#.........#.#...#...#.#...#.#.....#.#.#.#.#.#...#...#.#...#...#...#.#.#...#...#.....#
    #.#.###.#.#.#.#.#.#.#.#.#.#.#############.#.#####.#.###.#.#########.###.#.###.###.#.#####.#.#.#.#.#.###.###.#.###.###.###.#.#.#.#####.#####.#
    #...###...#...#...#...#...#...............#.......#.....#...........###...###.....#.......#...#...#.....###...###.....###...#...#####.......#
    #############################################################################################################################################""".trimIndent()