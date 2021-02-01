package level3;

import java.util.Scanner;

public class Main4676_늘어지는소리만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			String word = sc.next();
			int len = word.length();
			StringBuilder ans = new StringBuilder();

			//하이픈 개수, 위치에 따라 count
			int H = sc.nextInt();
			int []hipon = new int[len+1];
			for(int i = 0; i < H; i++) {
				int n = sc.nextInt();
				hipon[n] ++;
			}
			
			//sb에 기본 문자열과 하이픈 연결해주기
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < hipon[i]; j++) {
					ans.append('-');
				}
				ans.append(word.charAt(i));
			}
			for(int i = 0; i < hipon[len]; i++) {
				ans.append('-');
			}
			
			
			System.out.printf("#%d %s\n", t, ans.toString());
		}
	}
}
