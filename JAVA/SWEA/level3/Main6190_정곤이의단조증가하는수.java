package level3;

import java.util.Scanner;

public class Main6190_정곤이의단조증가하는수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int A[] = new int[N];
			int ans = -1;
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}


			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if(isDanjo(A[i] * A[j])) {
						ans = Math.max(ans, A[i]* A[j]);
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static boolean isDanjo(Integer num) {
		String temp = String.valueOf(num);
		
		for(int i = 0; i < temp.length()-1; i++) {
			int prev = temp.charAt(i) - '0';
			int nxt = temp.charAt(i+1) - '0';
			
			if(prev > nxt) {
				return false;
			}
		}
		
		return true;
	}

}
