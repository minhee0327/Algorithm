package level3;

import java.util.Scanner;

public class Main5607_조합 {
	public static long factorial[];
	public static long mod = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		fillFactorial();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			
			long top = factorial[N] % mod;
			long bottom = ((factorial[N - R]%mod) * (factorial[R]%mod)) % mod;
			
			long bottomToTop = powCalc(bottom, mod - 2);
			long ans = (top * bottomToTop) % mod;
		
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static long powCalc(long a, long p) {
		if (p == 0)
			return 1;

		long half = powCalc(a, p / 2);

		if (p % 2 == 0) {
			return ((half % mod) * (half % mod)) % mod;
		} else {
			return ((a * half % mod) * (half % mod)) % mod;
		}
	}

	private static void fillFactorial() {
		factorial = new long[1000001];
		factorial[0] = 1;

		for (int i = 1; i < factorial.length; i++) {
			factorial[i] = (factorial[i - 1] * i) % mod;
		}
	}

}

/*
 * [참조 링크] https://minkwon4.tistory.com/25
 */
