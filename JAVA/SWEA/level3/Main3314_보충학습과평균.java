package level3;

import java.util.Scanner;

public class Main3314_보충학습과평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int arr[] = new int [5];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				if(arr[i]<40) {
					arr[i] = 40;
				}
			}
			System.out.printf("#%d %d\n", t, avg(arr));
		}
	}

	private static int avg(int[] arr) {
		int ret = 0;
		for(int i: arr) {
			ret += i;
		}
		ret /= arr.length;
		return ret;
	}
}
