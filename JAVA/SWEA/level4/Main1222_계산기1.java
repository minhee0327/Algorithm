package level4;

import java.util.Scanner;

public class Main1222_계산기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			String[] nums = sc.next().split("\\+"); 
			int ans = 0;
			
			for(int i = 0; i < nums.length; i++) {
				ans += Integer.parseInt(nums[i]);
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
