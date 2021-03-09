package programmers.stackQueue;

import java.util.Arrays;

public class 주식가격 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3})));
//		System.out.println(Arrays.toString(solution2(new int[] {1, 2, 3, 2, 3})));
	}
	
	public static int[] solution (int[] prices) {
		int ret[] = new int[prices.length];
		
		for(int i = 0; i < prices.length-1; i++) {
			int cnt = 0;
			for(int j = i + 1; j< prices.length; j++) {
				if(prices[i] <= prices[j]) {
					cnt++;
				}else {
					cnt++;
					break;
				}
			}
			ret[i] = cnt;
		}
		
		return ret;
	}
	

}
