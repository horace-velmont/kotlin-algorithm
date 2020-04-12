package baekjoon

import java.lang.Integer.max
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt() // 1<=N<=15
    val arr = Array(N) { _ -> Pair(nextInt(), nextInt()) }

    fun decision(counsel: Boolean, step: Int, left: Int, acc: Int): Int {
        if (step < N) {
            var newLeft = left
            var newAcc = acc
            when {
                left > 0 -> newLeft = left - 1
                counsel -> {
                    newLeft = arr[step].first - 1
                    newAcc = if (arr[step].first > N - step) acc else acc + arr[step].second
                }
            }
            return max(decision(true, step + 1, newLeft, newAcc), decision(false, step + 1, newLeft, newAcc))
        }
        return acc
    }

    val max = max(decision(true, 0, 0, 0), decision(false, 0, 0, 0))
    print(max)
}
