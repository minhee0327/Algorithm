package level3;

import java.util.Scanner;

public class Main3975_승률비교하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			
			double ALICE = A*1.0/B;
			double BOB = C*1.0/D;

			System.out.printf("#%d %s\n", t, (ALICE>BOB)?"ALICE":(ALICE==BOB)?"DRAW":"BOB");

		}
	}

}
