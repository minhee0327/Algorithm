package level3;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main3233_정사각형분할놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.printf("#%d %d\n", t, BigDecimal.valueOf(Math.pow(A/B, 2)).toBigInteger());
		}
	}

}
