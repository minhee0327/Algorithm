package level3;

import java.util.Scanner;

public class Main2817_부분수열의합 {
	public static int arr[];
	public static int cnt, N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();

			arr = new int[N];
			cnt = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			dfs(0, 0);

			System.out.printf("#%d %d\n", t, cnt);
		}

	}

	private static void dfs(int idx, int sum) {
		if (sum == K) {
			cnt++;
			return;
		}
		if (idx >= N || sum > K)
			return;

		dfs(idx + 1, sum + arr[idx]);
		dfs(idx + 1, sum);
	}

}
