package programmers.dp;

public class RoadToSchool {
    public static void main(String[] args) {
        System.out.println(new Sol3().solution(4, 3, new int[][]{{2, 2}})); //문제에 주어진 TC
        System.out.println(new Sol3().solution(4, 3, new int[][]{{1, 2}, {2, 1}})); //해당 TC 처음부터 갈 길이 막혔으니 0
    }
}
//풀이 정리 중
class Sol3 {
    int[][] dp;
    int m, n;

    public int solution(int m, int n, int[][] puddles) {
        this.m = m;
        this.n = n;
        dp = new int[n + 1][m + 1];

        initArr(puddles);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    if (dp[i][j - 1] > 0) dp[i][j] += dp[i][j - 1] % 1000000007;
                    if (dp[i - 1][j] > 0) dp[i][j] += dp[i - 1][j] % 1000000007;
                }
            }
        }
        return dp[n][m] % 1000000007;
    }

    public void initArr(int[][] puddles) {
        dp[1][1] = 1;
        //웅덩이 위치 표시 (-1)
        for (int[] p : puddles) {
            dp[p[1]][p[0]] = -1;
        }
    }
}