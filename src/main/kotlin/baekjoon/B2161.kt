package baekjoon

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    var arr = Array(N) { i -> i + 1 }
    while (arr.size > 1) {
        print("${arr[0]} ")
        arr = arr.sliceArray(1 until arr.size)
        if (arr.size > 1) arr = arr.sliceArray(1 until arr.size).plus(arr[0])
    }
    print(arr[0])
}
