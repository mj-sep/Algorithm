import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.text.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val str = mutableSetOf<String>()

    for(x in 0..input.length) {
        for (y in x+1 .. input.length) {
            val splitStr = input.substring(x, y)
            str.add(splitStr)
        }
    }

    println(str.size)

}