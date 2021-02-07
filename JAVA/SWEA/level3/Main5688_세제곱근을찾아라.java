package level3;

import java.util.Scanner;

public class Main5688_세제곱근을찾아라 {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
			
			int T = sc.nextInt();
			
			for(int t = 1; t <= T; t++) {
				long N = sc.nextLong();
				Double cbrt = Math.cbrt(N);
				
				if(cbrt == cbrt.intValue()) {
					System.out.printf("#%d %d\n", t, cbrt.intValue());
				}else {
					System.out.printf("#%d %d\n", t, -1);
				}
			}
		}
	}