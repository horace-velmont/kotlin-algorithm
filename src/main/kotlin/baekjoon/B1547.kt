package baekjoon

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val M = nextInt()
    val arr = Array(3) { i -> i }
    for (i in 0 until M) {
        val a = nextInt() - 1
        val b = nextInt() - 1

        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }
    print(arr.indices.filter { i -> arr[i] == 0 }[0] + 1)
}
