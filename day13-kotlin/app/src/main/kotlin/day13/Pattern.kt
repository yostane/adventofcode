package day13

import kotlin.math.max

data class Pattern(val lines: List<String>){
    private val columns = lines[0].indices.map { getColumn(it) }
    private fun countRowsBeforeReflection(rows: List<String>): Int {
        for (i in rows.indices){
            if (rows[i] == rows[i+1])
                    return i
            }
        }
        return 0
    }

    private fun getColumn(column: Int): String {
        val sb = StringBuilder()
        for(i in lines.indices){
            sb.append(lines[i][column])
        }
        return sb.toString()
    }

    fun countColumnsBeforeReflectionColumn(): Int {
        return countRowsBeforeReflection(columns)
    }

    fun countLinesBeforeReflection(): Int {
        return countRowsBeforeReflection(lines)
    }

    fun getPerfectReflexionCount(): Int {
        val lineCount = countLinesBeforeReflection()
        val colCount = countColumnsBeforeReflectionColumn()
        return  if (lineCount >= colCount) lineCount * 100 else colCount
    }
}