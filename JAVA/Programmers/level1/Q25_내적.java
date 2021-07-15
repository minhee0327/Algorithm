package programmers.level1;

public class Q25_내적 {
    public static void main(String[] args) {
        System.out.println(new Solution25().solution(new int[]{1,2,3,4}, new int[] {-3,-1,0,2}));
        System.out.println(new Solution25().solution(new int[]{-1,0,1}, new int[] {1,0,-1}));
    }
}

class Solution25{
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++){
            answer+= (a[i] * b[i]);
        }
        return answer;
    }
}