package programmers.lesson

import java.util.*

fun main(args: Array<String>) {
    val l = L42588()
    l.solution(intArrayOf(6, 9, 5, 7, 4)).forEach { k -> print(k) }
}

class L42588 {
    fun solution(heights: IntArray): IntArray {
        val answer = IntArray(heights.size) { 0 }
        val stk: Stack<Int> = Stack()
        for (i in heights.indices) {
            stk.push(heights[i]);
            val copyArr: Array<Int> = Array(stk.size) { 0 };
            stk.copyInto(copyArr);
            for (j in copyArr.size - 2 downTo 0) {
                if (copyArr[j] > heights[i]) {
                    answer[i] = j + 1;
                    break
                }
            }
        }
        return answer
    }
}
