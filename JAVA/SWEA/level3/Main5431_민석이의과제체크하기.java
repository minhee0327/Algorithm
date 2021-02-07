package level3;

import java.util.Scanner;

public class Main5431_민석이의과제체크하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			boolean students[] = new boolean[N + 1];
			for (int i = 0; i < K; i++) {
				students[sc.nextInt()-1] = true;
			}
			
			System.out.printf("#%d ", t);
			for (int i = 1; i <= N; i++) {
				if (!students[i-1]) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}

}
