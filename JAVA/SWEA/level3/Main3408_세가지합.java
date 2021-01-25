package level3;

import java.util.Scanner;

public class Main3408_세가지합 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			long N = sc.nextLong();
			
			long s1 = N*(N+1)/2;
			long s2 = N*N;
			long s3 = N*N+N;
			
			System.out.printf("#%d %d %d %d\n", t,s1, s2, s3);
		}
	}

}
