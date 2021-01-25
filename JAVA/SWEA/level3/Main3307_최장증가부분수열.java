package level3;

import java.util.Scanner;

public class Main3307_최장증가부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t<= T; t++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			int dp[] = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				dp[i] = 1;
			}
			
			for(int i = 1; i < N; i++) {
				for(int j = 0; j<i; j++) {
					if(arr[i]> arr[j]) {
						dp[i] = Math.max(dp[j] + 1, dp[i]);
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, max(dp));
			
		}
	}

	private static Object max(int[] dp) {
		int ret = Integer.MIN_VALUE;
		
		for(int d: dp) {
			if(d> ret) {
				ret = d;
			}
		}
		
		return ret;
	}

}
