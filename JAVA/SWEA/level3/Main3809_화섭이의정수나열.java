package level3;

import java.util.Scanner;

public class Main3809_화섭이의정수나열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			String s = "";
			int idx = 0;

			for (int i = 0; i < N; i++) {
				s += sc.next();
			}

			while (true) {
				if (!s.contains(idx + "")) {
					break;
				}
				idx++;
			}
			System.out.printf("#%d %d\n", t, idx);
		}
	}

}
