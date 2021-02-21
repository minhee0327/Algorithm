package level4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1232_사칙연산 {
	public static int n;
	public static String input[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			sc.nextLine();

			input = new String[N + 1][4];

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				int j = 0;
				while (st.hasMoreTokens()) {
					input[i][j] = st.nextToken();
					j++;
				}
			}
			System.out.printf("#%d %d\n", t, dfs(1));
		}
	}

	private static int dfs(int v) {
		if (input[v][1].equals("+")) {
			return dfs(Integer.parseInt(input[v][2])) + dfs(Integer.parseInt(input[v][3]));
		} else if (input[v][1].equals("-")) {
			return dfs(Integer.parseInt(input[v][2])) - dfs(Integer.parseInt(input[v][3]));
		} else if (input[v][1].equals("*")) {
			return dfs(Integer.parseInt(input[v][2])) * dfs(Integer.parseInt(input[v][3]));
		} else if (input[v][1].equals("/")) {
			return dfs(Integer.parseInt(input[v][2])) / dfs(Integer.parseInt(input[v][3]));
		} else {
			return Integer.parseInt(input[v][1]);
		}
	}

}
