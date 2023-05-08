import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val list = br.readLine().split(' ')
    val arr_s = mutableSetOf<Int>()
    val M = br.readLine().toInt()
    val list2 = br.readLine().split(' ')
    val arr_j = mutableSetOf<Int>()

    for (x in 0 until list.size) {
        arr_s.add(list.get(x).toInt())
    }

    for (x2 in 0 until list2.size) {
        arr_j.add(list2.get(x2).toInt())
    }

    val sb= StringBuilder()
    for (item in arr_j) {
        if (arr_s.contains(item)) sb.append("1")
        else if (!arr_s.contains(item)) sb.append("0")
        sb.append(" ")
    }

    println(sb)
}
