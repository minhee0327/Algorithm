package programmers.level2;

import java.util.Arrays;

public class Sol5 {
    public static void main(String[] args) {
        System.out.println(new Solution5().solution(new int[]{1,4,2}, new int[]{5,4,4}));
        System.out.println(new Solution5().solution(new int[]{1,2}, new int[]{3, 4}));
    }
}

//최솟값 만들기
class Solution5{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[B.length-1-i];
        }

        return answer;
    }
}