package programmers.d20200418;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.solution("00000000000000000000", "91919191919191919191"));
    }

    public int solution(String p, String s) {
        char[] pArr = p.toCharArray();
        char[] cArr = s.toCharArray();
        int answer = 0;
        for (int i = 0; i < p.length(); i++) {
            int ip = pArr[i], cp = cArr[i];
            int max = Math.max(ip, cp), min = Math.min(ip, cp);
            answer += Math.min(max - min, min + 10 - max);
        }
        return answer;
    }
}
