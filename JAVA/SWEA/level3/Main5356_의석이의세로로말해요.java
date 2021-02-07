package level3;

import java.util.Scanner;

public class Main5356_의석이의세로로말해요 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			String [] arr = new String[5];
			int maxLen = 0;
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.next();
				if(arr[i].length() > maxLen) {
					maxLen = arr[i].length();
				}
			}
			
			for(int i = 0; i < maxLen; i++) {
				for(int j = 0; j < 5; j++) {
					if(i >= arr[j].length()) {
						continue;
					}
					sb.append(arr[j].charAt(i));
				}
			}
			
			System.out.printf("#%d %s\n", t, sb.toString());
		}
	}

}
