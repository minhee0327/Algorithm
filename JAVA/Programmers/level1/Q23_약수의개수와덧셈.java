package programmers.level1;

public class Q23_약수의개수와덧셈 {
    public static void main(String[] args) {
        System.out.println(new Solution23().solution(13, 17));
        System.out.println(new Solution23().solution(24, 27));
    }
}

class Solution23{
    public int solution(int left, int right){
        int answer = 0;

        for(int i = left; i <= right ; i++){
            int cnt = findCount(i);
            if(cnt %2== 0) {
                answer += i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }

    public int findCount(int num){
        int ret = 0;
        for(int i = 1; i <= num; i++){
            if(num % i == 0) ret++;
        }
        return ret;
    }
}