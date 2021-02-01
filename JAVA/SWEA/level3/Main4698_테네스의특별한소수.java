package level3;

import java.util.Scanner;

public class Main4698_테네스의특별한소수 {
	public static boolean[] sosu = new boolean[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		makesosu();

		for (int t = 1; t <= T; t++) {
			String D = sc.next();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int ans = 0;

			for (int i = A; i <= B; i++) {
				if (sosu[i] && String.valueOf(i).contains(D)) {
					ans++;
				}
			}

			System.out.printf("#%d %d\n", t, ans);

		}

	}

	private static void makesosu() {
		for (int i = 2; i < sosu.length; i++) {
			boolean flag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				sosu[i] = true;
			}
		}
	}
	
	//makesosu1은 다른 solution. 이걸로 돌리고 싶을 땐 main함수에서 조건문에 sosu[i] 앞에 !을 붙여서 볼 것!
	private static void makesosu1() {
		for (int i = 2; i < Math.sqrt(sosu.length); i++) {
			if(sosu[i]) {
				continue;
			}
			for(int j = i + i ; j <=1000000; j+=i) {
				sosu[j] = true;
			}
		}
	}
	
	
}
