package level4;

import java.util.Scanner;

public class Main1226_미로1 {
	public static int[][] matrix;
	public static boolean[][] visitied;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static int N = 16;
	public static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt();

			matrix = new int[N][N];
			visitied = new boolean[N][N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				String temp = sc.next();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = temp.charAt(j) - '0';
				}
			}
			dfs(1, 1);

			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static void dfs(int x, int y) {
		visitied[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (matrix[nx][ny] == 3) {
				ans = 1;
				return;
			}

			if (0 <= nx && nx < N && 0 <= ny && ny < N && !visitied[nx][ny] && matrix[nx][ny] == 0) {
				dfs(nx, ny);
			}
		}
	}
}
