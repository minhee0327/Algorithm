package level3;

import java.util.Scanner;

public class Main3282_Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int bag[][] = new int[N+1][K+1];
			int w[] = new int[N+1];
			int v[] = new int[N+1];
			
			for(int i =1; i<=N; i++) {
				w[i] = sc.nextInt();
				v[i] = sc.nextInt();
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= K; j++) {
					bag[i][j] = bag[i-1][j];
					
					if(j - w[i] >= 0) {
						bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j-w[i]] + v[i]);
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, bag[N][K]);
		}
	}

}
