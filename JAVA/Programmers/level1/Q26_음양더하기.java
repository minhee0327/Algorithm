package programmers.level1;

public class Q26_음양더하기 {
    public static void main(String[] args) {
        System.out.println(new Solution26().solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}));
    }
}

class Solution26 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < signs.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
