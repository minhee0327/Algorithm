package level3;

import java.util.Scanner;

public class Main6485_삼성시의버스노선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int bus[] = new int[5001];
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0 ; i < N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				for(int j = A; j<= B; j++) {
					bus[j]++;
				}
			}
			
			int P = sc.nextInt();
			
			for(int i = 0; i < P ; i++) {
				sb.append(bus[sc.nextInt()] + " ");
			}
			
			System.out.printf("#%d %s\n", t, sb.toString());
		}
	}

}
