package programmers.level2;

//피보나치 수
public class Sol4 {
    public static void main(String[] args) {

    }
}

class Solution4{
    int[] dp;
    public int solution (int n){
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-1]+ dp[i-2]) % 1234567;
        }

        return dp[n] % 1234567;
    }
}