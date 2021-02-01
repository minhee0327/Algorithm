package level3;

import java.util.Scanner;

public class Main5162_두가지빵의딜레마 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int ans = 0;

			ans += c / Math.min(a, b);
			c %= Math.min(a, b);
			ans += c / Math.max(a, b);

			System.out.printf("#%d %d\n", t, ans);

		}
	}

}
