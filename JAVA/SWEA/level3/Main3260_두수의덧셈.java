package level3;

import java.math.BigInteger;
import java.util.Scanner;

public class Main3260_두수의덧셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			BigInteger A = sc.nextBigInteger();
			BigInteger B = sc.nextBigInteger();
			System.out.printf("#%d %d\n", t, A.add(B));
		}
	}

}
