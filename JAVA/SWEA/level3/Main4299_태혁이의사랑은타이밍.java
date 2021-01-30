package level3;

import java.util.Scanner;

public class Main4299_태혁이의사랑은타이밍 {
	public static int pivotDay = 11 * 24 * 60 + 11 * 60 + 11;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int D = sc.nextInt();
			int H = sc.nextInt();
			int M = sc.nextInt();

			int RecognizedDay = D * 24 * 60 + H * 60 + M;

			if (RecognizedDay - pivotDay < 0) {
				System.out.printf("#%d %d\n", t, -1);
			} else {
				System.out.printf("#%d %d\n", t, RecognizedDay - pivotDay);
			}
		}

		sc.close();
	}

}
