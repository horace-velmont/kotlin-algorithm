package baekjoon

import java.util.*
import kotlin.math.pow

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    var num = 0
    var cnt = -1
    val cache = BooleanArray(100)
    fun isDescendent(num: Int): Boolean {
        val str = num.toString()
        var flag = true

        for (i in 0 until str.length-1) {
            //if (cache((str[i] + str[i+1]).toInt()))
            if (str[0] <= str[1]) {
                flag = false
            }
            if (flag && str.length > 2) {
                val pow = (10.0.pow(str.length)).toInt()
                val leftShift = num - (num / pow) * pow;
                flag = if (leftShift < 10) false else cache[leftShift]
            }
        }
        return flag
    }

    var sol = 0
    while (cnt < N) {
        if (isDescendent(num)) {
            cache[num] = true
            cnt += 1
            sol = num
        }
        num += 1
    }
    print(sol)
}
