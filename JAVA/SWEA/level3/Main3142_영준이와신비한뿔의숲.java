package level3;

import java.util.Scanner;

public class Main3142_영준이와신비한뿔의숲 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t= 1; t <=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.printf("#%d %d %d\n", t, 2*M-N , N-M);
		}
	}

}
