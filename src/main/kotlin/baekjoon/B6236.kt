package baekjoon

import java.lang.Integer.max
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()
    val arr = IntArray(N)
    var max = 0
    for (i in 0 until N) {
        val elem = nextInt()
        max = max(max, elem)
        arr[i] = elem
    }
    fun withDraw(cost: Int): Int {
        var cur = 0
        var cnt = 0
        for (i in 0 until N) {
            if (cur < arr[i]) {
                cnt++
                cur = cost - arr[i]
            } else {
                cur -= arr[i]
            }
        }
        return cnt
    }

    var low = max
    var high = 1000000000
    var mid = 0
    while (low < high) {
        mid = ((low + high) / 2)
        if (withDraw(mid) > M) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    print(mid)
}
