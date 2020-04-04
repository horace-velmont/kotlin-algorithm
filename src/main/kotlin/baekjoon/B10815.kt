package baekjoon

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val ownCards = Array(N) { nextInt() }
    ownCards.sort()
    val T = nextInt()
    val questions = Array(T) { nextInt() }

    fun search1(arr: Array<Int>, search: Int): Int {
        var mid: Int;
        var low = 0
        var high = arr.size - 1
        while (low <= high) {
            mid = (low + high) / 2
            if (search == arr[mid]) {
                return 1
            }
            if (search < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1
            }
        }
        return 0
    }

    fun search2(arr: Array<Int>, search: Int, low: Int = 0, high: Int = arr.size - 1): Int {
        val mid: Int;
        while (low <= high) {
            mid = (low + high) / 2
            return when {
                search == arr[mid] -> {
                    1
                }
                search < arr[mid] -> {
                    search2(arr, search, low, mid - 1)
                }
                else -> {
                    search2(arr, search, mid + 1, high)
                }
            }
        }
        return 0
    }
    for (i in 0 until T) {
        val question = questions[i]
        print("${search2(ownCards, question)} ")
    }
}
