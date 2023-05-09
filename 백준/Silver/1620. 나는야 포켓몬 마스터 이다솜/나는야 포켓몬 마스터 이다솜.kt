import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.text.StringBuilder

fun main() {
    /*
    첫째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 말해줬으면 좋겠어!!!.
    입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을,
    문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력하면 돼.
    */

    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")
    val N = input[0].toInt()
    val M = input[1].toInt()
    val poketmon = mutableMapOf<String, Int>()
    val poketmonName = mutableListOf<String>()

    // Map으로 입력 받기
    for (x in 1..N) {
        val name = br.readLine()
        poketmon[name] = x
        poketmonName.add(name)
    }

    val sb = StringBuilder()
    for (x in 1..M){
        val prt = br.readLine()
        if(isNumber(prt)) sb.append("${poketmonName[prt.toInt()-1]}\n")
        else {
            sb.append("${poketmon[prt]}\n")
        }
    }
    println(sb)

}

// 정수 판별
fun isNumber(s: String): Boolean {
    return try {
        s.toInt()
        true
    } catch (ex: NumberFormatException) {
        false
    }
}