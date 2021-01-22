package level3;

import java.util.Scanner;

public class Main3032_홍준이의숫자놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int[] result = EE(A, B);
			
			if( result[0] != 1 ) {
				System.out.format("#%d %d\n", tc, -1);
			}else {
				System.out.format("#%d %d %d\n", tc, result[1], result[2]);
			}
		}
		sc.close();
	}
	
	private static int[] EE(int a, int b) {
		int s0 = 1, s1 = 0;
		int t0 = 0, t1 = 1;
		int q = 0;
		while(true) {
			q = a/b;
			a = a%b;
			s0 = s0 - s1 * q;
			t0 = t0 - t1 * q;
			
			if(a == 0) {
				int gcd = b;
				int[] xy = {gcd, s1, t1};
				return xy;
			}
			
			q = b/a;
			b = b%a;
			s1 = s1 - s0 * q;
			t1 = t1 - t0 * q;
			
			if(b == 0) {
				int gcd = a;
				int[] xy = {gcd, s0, t0};
				return xy;
			}
		}
	}
}

