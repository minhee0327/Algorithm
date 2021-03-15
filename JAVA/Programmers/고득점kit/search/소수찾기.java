package programmers.search;

import java.util.HashSet;

public class 소수찾기 {

	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}
	static boolean arr[];
	static HashSet <Integer> hs;
	private static int solution(String numbers) {
		hs = new HashSet<Integer>();
		
		//1. 소수 판별 (최대크키 9999999 => 10000000);
		arr = new boolean[10000000];
		
		for(int i = 2; i < 10000000; i++) {
			boolean flag= true;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				arr[i] = true;
			}
		}
		
		
		//2. 순열로 숫자들 확인하면서 소수면 hashset에 담아서 중복제거
		for(int i = 1; i <= numbers.length(); i++) {
			permutation(numbers.toCharArray(), 0, numbers.length(), i);
		}
		
		
		return hs.size();
	}

	private static void permutation(char[] numbers,int depth, int n, int r) {
		if(r==depth) {
			String temp = "";
			
			for(int i = 0; i < r;i++) {
				temp+= numbers[i];
			}
			int num = Integer.parseInt(temp);
			if(arr[num]) {
				hs.add(num);
			}
			return;
		}
		
		for(int i = depth; i < n; i++) {
			swap(numbers, depth, i);
			permutation(numbers, depth+1, n, r);
			swap(numbers, depth, i);
		}
	}

	private static void swap(char[] numbers, int depth, int i) {
		char temp = numbers[depth];
		numbers[depth] = numbers[i];
		numbers[i] = temp;
	}

}
