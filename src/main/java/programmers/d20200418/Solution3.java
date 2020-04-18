package programmers.d20200418;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    private static int min = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution(new int[]{10, 40, 30, 2}, 20));
    }

    public int solution(int[] numbers, int K) {
        List<Integer> blackList = makeBlackList(numbers, K);
        if (blackList.size() == 0) {
            return 0;
        }

        int cnt = 0;
        List<int[]> blkArr = new ArrayList<>();
        while (cnt < numbers.length) {
            for (int b : blackList) {
                for (int i = 0; i < numbers.length; i++) {
                    int[] copyArr = Arrays.copyOf(numbers, numbers.length);
                    if (b != i) {
                        swap(copyArr, b, i);
                        List<Integer> newBlkList = makeBlackList(copyArr, numbers.length);
                        if (newBlkList.size() == 0) {
                            return cnt;
                        }
                    }
                    blkArr.add(copyArr);
                }
            }
            cnt++;
        }
        return -1;
    }


    public List<Integer> makeBlackList(int[] numbers, int K) {
        List<Integer> blackList = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            if (Math.abs(numbers[i] - numbers[i + 1]) > K) {
                blackList.add(i);
            }
        }
        return blackList;
    }

    public void swap(int[] numbers, int a, int b) {
        int temp = a;
        numbers[a] = b;
        numbers[b] = temp;
    }
}
