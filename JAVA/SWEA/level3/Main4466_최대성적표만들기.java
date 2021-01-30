package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main4466_최대성적표만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t<= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			List <Integer> list = new ArrayList<Integer>();
			int ans = 0;
			
			for(int i = 0; i < N; i ++) {
				list.add(sc.nextInt());
			}
			
			list.sort(Collections.reverseOrder());
			
			for(int i = 0; i < K; i++) {
				ans += list.get(i);
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
