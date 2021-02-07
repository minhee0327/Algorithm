package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5986_새샘이와세소수 {
	public static List<Integer> sosu;
	public static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			sosu = new ArrayList<Integer>();
			ans = 0;
			
			
			findsosu(N);
			countAvaiableN(N, sosu.size());	
			System.out.printf("#%d %d\n", t, ans);
		}
		
		
	}
	private static void countAvaiableN(int n, int len) {
		for(int i = 0; i < len; i++) {
			for(int j = i; j < len; j++) {
				if(sosu.get(i) + sosu.get(j)>=n) break;
				for(int k = j; k <len; k++) {
					if(sosu.get(i) + sosu.get(j)+ sosu.get(k) == n) ans++;
				}
			}
		}
	}
	private static void findsosu(int n) {
		for(int i = 2; i <=n; i++) {
			boolean flag = true;
			for(int j = 2; j<= Math.sqrt(i); j++) {
				if(i %j ==0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				sosu.add(i);
			}
		}
	}

}
