package programmers.lesson;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class L42626 {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pQ = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(pQ::offer);

        if (isScov(pQ, K)) {
            return 0;
        } else {
            int answer = 0;
            while (pQ.size() > 1) {
                answer += 1;
                int scovNum = pQ.poll() + pQ.poll() * 2;
                pQ.offer(scovNum);
                if (isScov(pQ, K)) {
                    return answer;
                }
            }
            return -1;
        }
    }

    private boolean isScov(Queue<Integer> q, int K) {
        for (int elem : q) {
            if (elem < K) {
                return false;
            }
        }
        return true;
    }
}
