package level3;

import java.util.Scanner;

public class Main4789_성공적인공연기획 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			char[] people = sc.next().toCharArray();
			int L = people.length;
			int total = 0;
			int ans = 0;

			for (int i = 0; i < L; i++) {
				if (total >= i) {
					total += people[i] - '0';
				} else {
					ans += i - total;
					total = (people[i] - '0') + i;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
