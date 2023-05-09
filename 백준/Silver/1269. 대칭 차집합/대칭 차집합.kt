import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.text.StringBuilder

fun main() {
    /*
    자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다.
    이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오.
    */

    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")

    val aSet = mutableSetOf<Int>()
    val bSet = mutableSetOf<Int>()
    var AminusBSet = 0; var BminusASet = 0;


    val aInput = br.readLine().split(" ")
    val bInput = br.readLine().split(" ")

    for (x in 1..aInput.size) { aSet.add(aInput.get(x-1).toInt()) }
    for (x in 1..bInput.size) { bSet.add(bInput.get(x-1).toInt()) }

    aSet.forEach {
        if(bSet.contains(it)) BminusASet++
    }

    bSet.forEach {
        if(aSet.contains(it)) AminusBSet++
    }

    println(aSet.size-AminusBSet + bSet.size-BminusASet)

}