package programmers.level2;

import java.util.Arrays;

//이진변환 반복하기
public class Sol19 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution19().solution("110010101001")));
        System.out.println(Arrays.toString(new Solution19().solution("01110")));
        System.out.println(Arrays.toString(new Solution19().solution("1111111")));
    }
}

class Solution19{
    public int[] solution(String s) {
        int[] answer = {0,0};

        while(!s.equals("1")){
            String next = s.replaceAll("0", "");
            answer[1]+= s.length() - next.length();
            s = Integer.toBinaryString(next.length());
            answer[0]++;
        }

        return answer;
    }

}
