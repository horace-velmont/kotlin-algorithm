package baekjoon

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    val T = nextInt()
    for (i in 0 until T) {
        val M = nextInt()
        val N = nextInt()
        val K = nextInt()

        fun getScore(M: Int, N: Int, K: Int): Int {
            fun search(x: Int, y: Int, box: Array<BooleanArray>): Boolean {
                if (box[y][x]) {
                    box[y][x] = false
                    for (i in 0..3) {
                        if (x + dx[i] in 0 until M && y + dy[i] in 0 until N) {
                            search(x + dx[i], y + dy[i], box)
                        }
                    }

                    return true;
                }
                return false
            }

            val box = Array(N) { BooleanArray(M) }
            for (j in 0 until K) {
                val x = nextInt()
                val y = nextInt()
                box[y][x] = true
            }

            var cnt = 0;
            for (y in box.indices) for (x in box[0].indices) {
                if (search(x, y, box)) {
                    cnt += 1
                }
            }

            return cnt;
        }
        println(getScore(M, N, K))
    }
}
