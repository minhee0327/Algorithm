package level3;

import java.util.Arrays;
import java.util.Scanner;

public class Main3456_직사각형길이찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int arr[] = new int[3];
			int ans = 0;
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			if(arr[0]!= arr[1]) {
				ans = arr[0];
			}else if(arr[1]!= arr[2]) {
				ans = arr[2];
			}else {
				ans = arr[1];
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
