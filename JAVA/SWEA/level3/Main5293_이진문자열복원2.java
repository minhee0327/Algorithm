package level3;

import java.util.Scanner;

public class Main5293_이진문자열복원2 {
	public static String ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			ans = "";

			bfs(a, b, c, d, "0");
			bfs(a, b, c, d, "1");

			if(ans == "") ans = "impossible";
            System.out.format("#%d %s\n", t, ans);
		}
	}

	private static void bfs(int a, int b, int c, int d, String makingWord) {
		if (ans != "")
			return;
		//이 코드가 왜 들어가야만 했는지 다시 생각하는데 시간이 좀 걸렸다.
		//01(b) 또는 10(c) 가 만약 차이가 1보다 크다면 문자열을 복구할 수 없기 때문에 더 확인하지 않고 반환을 해야한다.
		//(서로다른 두 문자"1", "0" 의 비율을 맞춰야한다.)
		if (Math.abs(b - c) > 1)
			return;
		if (a < 0 || b < 0 || c < 0 || d < 0)
			return;
		if (a == 0 && b == 0 && c == 0 && d == 0) {
			ans = makingWord;
			return;
		}

		if (makingWord.substring(makingWord.length() - 1).equals("0")) {
			bfs(a - 1, b, c, d, makingWord + "0");
			bfs(a, b - 1, c, d, makingWord + "1");
		} else {
			bfs(a, b, c - 1, d, makingWord + "0");
			bfs(a, b, c, d - 1, makingWord + "1");
		}
	}

}

/* 맨 끝이 0으로 끝나면 다음에 붙일수 있는게 0, 1이니까 다음차례에 쓸 건 00, 01 */
/* 맨 끝이 1으로 끝나면 다음에 붙일수 있는게 0, 1이니까 다음차례에 쓸 건 10, 11 */
