import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.text.StringBuilder

fun main() {
    /*
    첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
    이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
    듣보잡의 수와 그 명단을 사전순으로 출력한다.
    */

    var br = BufferedReader(InputStreamReader(System.`in`))
    var input = br.readLine().split(" ")
    val inputSum = input[0].toInt() + input[1].toInt() // 전체 입력 수
    val output = mutableListOf<String>() // 출력값 저장하기 위한 list -> 사전 순으로 정렬하기 위함
    val mapHearorSee = mutableMapOf<String, Int>() // 듣도 보도 못한 사람 명단
    
    // 전체 입력 수만큼 for문을 돌리면서
    for(x in 0 until inputSum) {
        val inputStr = br.readLine()
        // map에 해당 입력값이 이미 있다면 -> 중복값이므로 output list에 추가
        if(mapHearorSee.contains(inputStr)) output.add(inputStr)
        // map에 해당 입력값이 없다면 -> 중복값이 아니므로 명단에 추가
        else mapHearorSee[inputStr] = x
    }
    output.sort() // 사전 순 정렬

    // map은 중복값 입력이 불가하므로, 전체 입력 받아야 할 수 - 최종적으로 명단에 들어간 인원 = 중복값
    println(inputSum - mapHearorSee.size)
    for(x in output) println(x)
}