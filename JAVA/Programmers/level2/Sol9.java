package programmers.level2;

import java.util.Arrays;

//다음 큰 숫자
public class Sol9 {
    public static void main(String[] args) {
    }
}

class Solution9{
    public int solution(int n) {
        int answer = 0;
        for(int i = n +1; i<= 1000000; i++){
            if(count(i) == count(n)){
                answer = i;
                break;
            }
        }
        return answer;
    }

    public int count(int num){
        String n = Integer.toBinaryString(num);
        String temp = String.valueOf(n);
        int ret = 0;
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == '1'){
                ret++;
            }
        }
        return ret;
    }

    //Integer.bitCount() 라는 메서드를 처음 접했는데, 앞으로 이진수로 count 해야할 때 유용할 듯 하다.
    public  int solution2(int n){
        int oriBinCnt = Integer.bitCount(n);
        for(int i = n+1; i <= 1000000; i++){
            if(oriBinCnt == Integer.bitCount(i)){
                return i;
            }
        }
        return 0;
    }
}