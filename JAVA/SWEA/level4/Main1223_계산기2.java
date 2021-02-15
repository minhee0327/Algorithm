package level4;

import java.util.Scanner;
import java.util.Stack;

public class Main1223_계산기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			String temp = sc.next();

			// 후위 표기로 변환
			String pos = changePosfix(temp);

			// 변환한 후위표기식 계산
			long ans = CalcPosfix(pos);
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static long CalcPosfix(String pos) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < pos.length(); i++) {
			char nxt = pos.charAt(i) ;
			if(0 <=nxt-'0' && nxt-'0' <10) {
				stack.add(nxt-'0');
			}else {
				int a = stack.pop();
				int b = stack.pop();
				if(nxt == '+') {
					stack.add(a + b);
				}else if(nxt == '*') {
					stack.add((a*b));
				}
			} 
		}
		return stack.pop();
	}

	private static String changePosfix(String temp) {
		String ret = "";
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < temp.length(); i++) {
			char nxt = temp.charAt(i);
			if (nxt -'0' >=0 && nxt - '0' < 10) {
				ret += temp.charAt(i);
			} else {
				while(!stack.isEmpty() && getPriority(nxt) <= getPriority(stack.peek())) {
					ret += stack.pop();
				}
				stack.push(nxt);
			}
		}
		while (!stack.isEmpty()) {
			ret += stack.pop();
		}
		return ret;
	}

	private static int getPriority(char nxt) {
		if(nxt == '+') {
			return 1;
		}else if (nxt == '*') {
			return 2;
		}
		return 1;
	}

}
