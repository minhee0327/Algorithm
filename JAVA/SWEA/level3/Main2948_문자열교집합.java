package level3;

import java.util.HashSet;
import java.util.Scanner;

public class Main2948_문자열교집합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int cnt = 0;

			HashSet<String> firstSet = new HashSet<String>();
			for (int i = 0; i < n; i++) {
				firstSet.add(sc.next());
			}

			for (int i = 0; i < m; i++) {
				if (firstSet.contains(sc.next())) {
					cnt++;
				}
			}

			System.out.printf("#%d %d\n", t, cnt);
		}
	}

}
