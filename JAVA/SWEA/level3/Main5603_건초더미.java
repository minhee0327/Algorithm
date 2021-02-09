package level3;

import java.util.Scanner;

public class Main5603_건초더미 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int sum=0, avg=0, ans= 0;
			
			int arr[] = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			
			avg = sum/N;
			
			for(int i = 0; i <N; i++) {
				if(arr[i] > avg) {
					ans += (arr[i] -avg);
				}
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
