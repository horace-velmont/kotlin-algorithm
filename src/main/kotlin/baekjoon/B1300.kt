package baekjoon

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val k = nextInt() + 1
    val i = if (k % N == 0) k / N else (k / N) + 1
    val j = if (k % N == 0) N else k % N
    println(i * j)
}
