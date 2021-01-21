package level3;

import java.util.Scanner;

public class Main2814_최장경로 {

	public static boolean[][] map;
	public static boolean visited[];
	public static int N, M;
	public static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new boolean[N + 1][N + 1];
			visited = new boolean[N + 1];
			ans = 0;
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				map[x][y] = true;
				map[y][x] = true;
			}

			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static void dfs(int v, int cnt) {
		ans = Math.max(ans, cnt);
		for (int i = 1; i <= N; i++) {
			if (map[v][i] && !visited[i]) {
				visited[v] = true;
				dfs(i, cnt + 1);
				visited[v] = false;
			}
		}
	}
}
