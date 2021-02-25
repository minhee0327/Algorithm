package level4;

import java.util.Scanner;

public class Main1865_동철이의일분배 {
	static int[][] matrix;
	static boolean[] visited;
	static int N;
	static double ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <=T; t++) {
			N = sc.nextInt();
			matrix = new int[N][N];
			ans = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < N; i++) {
				visited = new boolean[N];
				dfs(i, matrix[0][i]*0.01, 1);
			}
			
			System.out.printf("#%d %.6f\n", t, ans * 100);
		}
	}
	private static void dfs(int col, double p, int depth) {
		visited[col] = true;

		if(depth >= N && p > ans) {
			ans = p;
			visited[col] = false;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && p*matrix[depth][i]*0.01 > ans) {
				dfs(i, p*matrix[depth][i]*0.01, depth+1);
			}
		}
		visited[col] = false;
	}
}
