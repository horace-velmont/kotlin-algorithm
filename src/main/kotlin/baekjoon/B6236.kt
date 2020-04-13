package baekjoon

import java.lang.Integer.max
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()
    val arr = IntArray(N)
    var max = 0
    var sum = 0
    for (i in 0 until N) {
        val elem = nextInt()
        max = max(max, elem)
        sum += elem
        arr[i] = elem
    }
    fun withdraw(cost: Int): Int {
        var cur = 0
        var cnt = 0
        for (i in 0 until N) {
            if (cur < arr[i]) {
                cnt += 1
                cur = cost - arr[i]
            } else {
                cur -= arr[i]
            }
        }
        return cnt
    }

    var low = max
    var high = sum
    var mid: Int
    var sol = 0
    while (low <= high) {
        mid = ((low + high) / 2)
        if (withdraw(mid) > M) {
            low = mid + 1
        } else {
            sol = mid
            high = mid - 1
        }
    }
    print(sol)
}
