package level3;

import java.util.Scanner;

public class Main3750_DigitSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			long N = sc.nextLong();
			while (N >= 10) {
				N = sum(N);
			}

			System.out.printf("#%d %d\n", t, N);
		}
	}

	private static long sum(long n) {
		long ret = 0;
		while (n > 0) {
			ret += n % 10;
			n /= 10;
		}
		return ret;
	}

}
