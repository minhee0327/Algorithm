package level3;

import java.util.Scanner;

public class Main5515_2016년요일맞추기 {
	public static int monthOfdate[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int m = sc.nextInt();
			int d = sc.nextInt();

			int date = 0;

			for (int i = 0; i < m - 1; i++) {
				date += monthOfdate[i];
			}

			date += d;
			
			System.out.printf("#%d %d\n", t, (date+3)%7);
		}

	}

}
