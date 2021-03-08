package programmers.sort;

import java.util.Arrays;

public class Hindex {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
	}
	
	public static int solution(int[] citations) {
		Arrays.sort(citations);
		
		int hIndex = 0;

		for(int i = 0; i < citations.length; i++) {
			int h = Math.min(citations[i], citations.length - i);
			hIndex = Math.max(h, hIndex);
		}
		
		return hIndex;
	}
	
}

// 문제 설명: https://programmers.co.kr/questions/8885
// [0, 1, 3, 5, 6]
// 0 회 이상 인용된 논문 수 5
// 1 회 이상 인용된 논문 수 4
// 3 회 이상 인용된 논문 수 3
// 5 회 이상 인용된 논문 수 2
// 6 회 이상 인용된 논문 수 1

// 아무리 인용이 많이된 논문이라도, 논문수가 적으면 h 값도 작아지고
// 논문수가 많으면 인용이 적어져서 h 값도 작아지는 시스템.
// a 번 이상 인용된 논문의 수가 b 개일 때 => h: a, b 중 작은 값이고
// h-index는 이런 h 들 중 최댓값을 뜻한다.