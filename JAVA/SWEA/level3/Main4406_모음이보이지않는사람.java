package level3;

import java.util.Scanner;

public class Main4406_모음이보이지않는사람 {
	public static String vowels = "aeiou"; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			String str = sc.next();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < str.length(); i++) {
				if(!vowels.contains(Character.toString(str.charAt(i)))) {
					sb.append(str.charAt(i));
				}
			}
			
			System.out.printf("#%d %s\n", t, sb.toString());
		}
		sc.close();
	}

}
