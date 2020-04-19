package baekjoon

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    fun getScore(M: Int, N: Int, cbgArr: Array<Pair<Int, Int>>): Int {
        fun search(x: Int, y: Int, box: Array<IntArray>, chk: Array<BooleanArray>): Boolean {
            if (box[y][x] == 1 && !chk[y][x]) {
                chk[y][x] = true
                for (i in 0..3) {
                    search(x + dx[i], y + dy[i], box, chk)
                }
                return true;
            } else {
                return false;
            }
        }

        val box = Array(N) { IntArray(M) }
        val chk = Array(N) { BooleanArray(M) }
        var cnt = 0;
        cbgArr.forEach { p -> box[p.second][p.first] == 1 };

        for (y in box.indices) {
            for (x in box[0].indices) {
                if (search(x, y, box, chk)) {
                    cnt += 1
                    println("cnt : ${cnt}")
                }
            }
        }
        return cnt;
    }

    val T = nextInt()
    for (i in 0 until T) {
        val M = nextInt()
        val N = nextInt()
        val K = nextInt()
        val cbgArr = Array(K) { Pair(nextInt(), nextInt()) }
        println(getScore(M, N, cbgArr))
    }
}
