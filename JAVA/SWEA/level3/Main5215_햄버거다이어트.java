package level3;

import java.util.Scanner;

public class Main5215_햄버거다이어트 {
	public static int[] score, calories;
	public static int N, L, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			calories = new int[N];
			
			for(int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			ans = 0;
			dfs(0, 0, 0);

			System.out.printf("#%d %d\n", t ,ans);
		}
	}

	//s: 누적되어있는 score, c: 누적되어있는 calories
	private static void dfs(int cnt, int s, int c) {
		// 최대 칼로리보다 더 높아진 경우 종료
		if(c > L) {
			return;
		}
		//마지막 점수와 칼로리까지 온 경우들 중 여태까지 있던 ans보다 s가 더크면 업데이트 하고 종료
		if(cnt == N) {
			if(ans < s) ans = s;
			return;
		}
		//다음 조건을 선택 or 선택 하지 않은 경우 재귀적으로 탐색.
		dfs(cnt+1, s + score[cnt], c + calories[cnt]);
		dfs(cnt+1, s, c);
	}

}
