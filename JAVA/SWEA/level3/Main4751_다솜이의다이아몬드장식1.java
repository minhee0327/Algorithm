package level3;

import java.util.Scanner;

public class Main4751_다솜이의다이아몬드장식1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			StringBuilder sb1 = new StringBuilder(".");
			StringBuilder sb2 = new StringBuilder(".");
			StringBuilder sb3 = new StringBuilder("#");
			
			String word = sc.next();
			
			for(int i = 0 ; i < word.length(); i++) {
				sb1.append(".#..");
				sb2.append("#.#.");
				sb3.append("." + word.charAt(i) + ".#");
			}
			
			String arr[] = {sb1.toString(), sb2.toString(), sb3.toString(), sb2.toString(), sb1.toString()};
			for(String s : arr) {
				System.out.println(s);
			}
		}
	}

}
