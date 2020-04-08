package baekjoon

import java.util.*
import kotlin.math.max

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    var max = 0
    var sum = 0
    val arr = IntArray(N)
    for (i in arr.indices) {
        val elem = nextInt()
        max = max(max, elem)
        arr[i] = elem
        sum += elem
    }
    val M = nextInt()
    if (sum <= M) {
        println(max)
    } else {
        var low = 0
        var high = max
        var mid: Int = (low + high) / 2;
        var sol = mid
        while (low <= high) {
            mid = (low + high) / 2
            if (calc(arr, mid) > M) {
                high = mid - 1
            } else {
                sol = mid
                low = mid + 1
            }
        }
        print(sol)
    }
}

fun calc(arr: IntArray, upperBound: Int): Int {
    var sum = 0
    for (i in arr.indices) sum += if (arr[i] > upperBound) upperBound else arr[i]
    return sum
}
