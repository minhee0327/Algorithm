package level3;

import java.util.Scanner;

public class Main5601_쥬스나누기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < N; i++) {
				sb.append("1/"+N +" ");
			}
			
			System.out.printf("#%d %s\n", t, sb.toString());
		}
	}

}
