package programmers.sort;

import java.util.Arrays;

public class 가장큰수 {

	public static void main(String[] args) {
		int[] numbers1 = {6,10,2};
		int[] numbers2 = {3,30,34,5,9};
		
		System.out.println(solution(numbers1));
		System.out.println(solution(numbers2));
	}
	
	
	public static String solution(int[] numbers) {
		String answer = "";
		
		String[] numStr = new String[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			numStr[i] = String.valueOf(numbers[i]);
		}
		
//		Arrays.sort(numStr, new Comparator<String>() {
//			@Override
//			public int compare(String a, String b) {
//				return (b+a).compareTo(a+b);
//			}
//		});		
		
		Arrays.sort(numStr, (a, b) -> (b+a).compareTo(a + b));
		
		for(int i = 0; i < numStr.length; i++) {
			answer += numStr[i];
		}
		return answer;
	}
}
