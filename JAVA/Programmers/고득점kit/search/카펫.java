package programmers.search;

import java.util.Arrays;

public class 카펫 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(8, 1)));
		System.out.println(Arrays.toString(solution(24, 24)));
	}
	
	public static int[] solution(int brown, int yellow) {
		int b = (brown + 4)/2;
		int c = brown + yellow;
		
		int row = (b + (int) Math.sqrt(Math.pow(b, 2) - 4 *c))/2;
		int col = (b - (int) Math.sqrt(Math.pow(b, 2) - 4 *c))/2;
	
		return new int[] {row, col};
	}
}
