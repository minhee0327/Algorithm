package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3376_파도반수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		List <Long> list = new ArrayList<Long>();
		for(int i = 0; i <3; i++) {
			list.add(1L);
		}
		for(int i = 0; i<2; i++) {
			list.add(2L);
		}
		for(int i  = 0 ; i < 100 - 5; i++) {
			list.add(list.get(i) + list.get(i+4));
		}
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			System.out.printf("#%d %d\n", t, list.get(N-1));
		}
		
		sc.close();
	}

}
