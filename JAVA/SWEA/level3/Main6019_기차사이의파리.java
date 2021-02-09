package level3;

import java.util.Scanner;

public class Main6019_기차사이의파리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			double D = sc.nextDouble();
			double A = sc.nextDouble();
			double B = sc.nextDouble();
			double F = sc.nextDouble();
			
			System.out.printf("#%d %.10f\n", t, (D/(A+B) * F));
		}
	}

}
