package level3;

import java.util.Scanner;

public class Main4579_세상의모든팰린드롬2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			String str = sc.next();
			boolean flag = true;
			
			for(int i = 0; i < str.length()/2; i++) {
				if(str.charAt(i)=='*'||str.charAt(str.length()-i-1)=='*') {
					break;
				}else if(str.charAt(i) != str.charAt(str.length()-i-1)) {
					flag = false;
					break;
				} 
			}
			
			if(flag) {
				System.out.printf("#%d %s\n", t, "Exist" );
			}else {
				System.out.printf("#%d %s\n", t, "Not exist" );
			}
		}
	}
}
