package programmers.greedy;

import java.util.Stack;

public class 큰수만들기 {

	public static void main(String[] args) {
		System.out.println(solution("1924" , 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
		//testcase 12 error 
		System.out.println(solution("999", 2));
		System.out.println(solution("99991", 3));
		System.out.println(solution("111119", 3));
		
		System.out.println("=====================");
		
		System.out.println(solution2("1924" , 2));
		System.out.println(solution2("1231234", 3));
		System.out.println(solution2("4177252841", 4));
		//testcase 12 error 
		System.out.println(solution2("999", 2));
		System.out.println(solution2("99991", 3));
		System.out.println(solution2("111119", 3));
	}

	private static String solution(String number, int k) {
		boolean[] flag = new boolean[number.length()];
		
		for(int i = 0; i < number.length(); i++) {
			if(k<=0) {
				break;
			}
			
			if(number.length() - i > k) {
				for(int j = i+1; j< i+1+k; j++) {
					if(number.charAt(i) <number.charAt(j)) {
						flag[i] = true;
						k--;
						break;
					}
				}
			}else {
				flag[i] = true;
			}
			
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < number.length();i++) {
			if(!flag[i]) {
				sb.append(number.charAt(i));
			}
		}
		
		return sb.toString();
	}
	private static String solution2(String number, int k) {
		Stack <Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < number.length(); i++) {
			int c = number.charAt(i) - '0';
			
			while(!stack.isEmpty() && stack.peek() < c && k > 0) {
				stack.pop();
				k--;
			}
			 stack.push(c);
		}
		
		while (k>0) {
			stack.pop();
			k--;
		}
		
		StringBuilder sb = new StringBuilder(); 
		for(int i = 0; i < stack.size(); i++) {
			sb.append(String.valueOf(stack.get(i)));
		}
		
		return sb.toString();
	}

	private static String solution3(String number, int k) {
		Stack <Character> stack = new Stack<Character>();
		char[] result = new char[number.length() - k];
		
		for(int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			
			while(!stack.isEmpty() && stack.peek() < c && k > 0) {
				stack.pop();
				k--;
			}
			stack.push(c);
		}
		
		for(int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}
		return new String(result);
	}

}

