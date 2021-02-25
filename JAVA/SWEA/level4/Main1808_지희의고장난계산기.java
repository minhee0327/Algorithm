package level4;

import java.util.Scanner;

public class Main1808_지희의고장난계산기 {
	static int[] nums;
	static Scanner sc;
	static int X, min;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			inputNums();
			X = sc.nextInt();
			min = INF;
			
			search(X, 0);
			
			if(min == INF) {
				System.out.printf("#%d %d\n", t, -1);			
			}else {
				System.out.printf("#%d %d\n", t, min);			
			}
			
		}
	}

	private static void search(int cur, int cnt) {
		int clicks = count(cur);
		if(clicks > 0) {
			min = Math.min(min, clicks + cnt + 1); 
			return;
		}
		
		for (int i = 2; i < (int) Math.sqrt(cur); i++) {
			if (cur % i == 0) {
				clicks = count(i);
				if(clicks != 0) {
					search(cur/i, clicks + cnt +1);
				}
			}
		}

	}

	// 멀쩡한 번호 nums 배열에 입력받기 (멀쩡한거 1, 고장난거 0)
	private static void inputNums() {
		nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = sc.nextInt();
		}
	}

	//return 0 : 찾는 값(X)를 만들 수 없음. //0 보다 큰 수 return: X를 만들면서 필요한 길이.
	private static int count(int N) {
		int cnt = 0;
		while (N > 0) {
			int temp = N % 10;
			cnt++;
			if (nums[temp] == 0) {
				return 0;
			}
			N /= 10;
		}
		return cnt;
	}
}
