package level3;

import java.util.Arrays;
import java.util.Scanner;

public class Main1860_진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] time = new int[N];
			boolean flag = true;
			
			for(int i = 0; i < N; i++) {
				time[i] = sc.nextInt();
			}
			Arrays.sort(time);

			for(int i = 0; i < N; i++) {
				if ((time[i] / M) * K - (i+1) < 0) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				System.out.printf("#%d %s\n", t , "Possible");
			}else {
				System.out.printf("#%d %s\n", t , "Impossible");
				
			}
		}
	}
}