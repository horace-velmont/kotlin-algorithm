package baekjoon

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()
    val arr = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        for (j in 0 until M) {
            arr[i][j] = nextInt()
        }
    }
}
