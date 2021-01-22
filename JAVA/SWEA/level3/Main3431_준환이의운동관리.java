package level3;

import java.util.Scanner;

public class Main3431_준환이의운동관리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			
			int result = 0;
			
			if(X<L) {
				result = L-X;
			}else if(X>U) {
				result = -1;
			}else {
				result = 0;
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
	}

}
