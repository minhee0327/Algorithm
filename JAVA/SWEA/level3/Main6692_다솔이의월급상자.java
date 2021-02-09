package level3;

import java.util.Scanner;

public class Main6692_다솔이의월급상자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			double ans = 0;
			
			for(int i = 0; i <N; i++) {
				double p = sc.nextDouble();
				int x = sc.nextInt();
				
				ans += p*x;
			}
			
			System.out.printf("#%d %.6f\n", t, ans);
		}
	}

}
