package level3;

import java.util.Scanner;

public class Main3304_최장공통부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			char[] arr1 = sc.next().toCharArray();
			char[] arr2 = sc.next().toCharArray();
			
			int dp[][] = new int[arr1.length + 1][arr2.length + 1];
			for(int i = 1; i <= arr1.length; i++) {
				for(int j = 1; j <= arr2.length; j++) {
					
					if(arr1[i-1]==arr2[j-1]) {
						dp[i][j] = dp[i-1][j-1] + 1;
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, dp[arr1.length][arr2.length]);
		}
	}

}
