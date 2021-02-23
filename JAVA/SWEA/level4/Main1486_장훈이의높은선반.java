package level4;

import java.util.Scanner;

public class Main1486_장훈이의높은선반 {
	static int N, B; 
	static int[] H;
	static int minVal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];
			minVal = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}

			search(0, 0);
			
			System.out.printf("#%d %d\n",t, minVal-B);
		}
	}
	private static void search(int depth, int sum) {
		if(sum >= B && sum <=minVal) {
			minVal = sum;
			return;
		}

		if(depth>= H.length) {
			return;
		}
		
		search(depth+1, sum + H[depth]);
		search(depth+1, sum);
	}

}

/*문제 보고 생각났던 알고리즘: 조합(백트래킹), 완전탐색, 완전탐색구현이 좀더 쉽게 생각나서 사용함.*/