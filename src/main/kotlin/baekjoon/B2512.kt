package baekjoon

import java.util.*

fun totalBudget(arr: Array<Int>, upperLimit: Int) =
    arr.reduce { sum, elem -> if (elem > upperLimit) sum + upperLimit else sum + elem }

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val arr = Array(N) { nextInt() }
    arr.sort()
    val M = nextInt()
    val sum = arr.sum()
    if (sum <= M) {
        print(arr.max())
    } else {
        var low = arr[0]
        var high = arr[arr.size - 1]
        var mid: Int = (low + high) / 2;
        var sol = mid
        while (low <= high) {
            mid = (low + high) / 2
            val bud = totalBudget(arr, mid)
            if (bud > M) {
                high = mid - 1
            } else {
                sol = mid
                low = mid + 1
            }
        }
        print(sol)
    }
}
