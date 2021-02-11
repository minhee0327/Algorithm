package level4;

import java.util.Scanner;
import java.util.Stack;

public class Main1218_괄호짝짓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for(int t = 1 ; t <= 10; t++) {
			int N = sc.nextInt();
			String bracket = sc.next();
			Stack <Character> stack = new Stack<Character>();
			int ans = 1;
			
			for(int i = 0; i < N; i++) {
				char c = bracket.charAt(i);
				if(c =='(' || c == '<' || c == '{' || c=='[') {
					stack.add(c);
				}else {
					if(stack.isEmpty()) {
						ans = 0;
						break;
					}else if(isCouple(stack.peek(), c)) {
						stack.pop();
						continue;
					}else {
						ans = 0;
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static boolean isCouple(Character l, char r) {
		if(l == '(' && r == ')') {
			return true;
		}else if (l == '<' && r == '>') {
			return true;
		}else if (l == '{' && r == '}') {
			return true;
		}else if (l == '[' && r == ']') {
			return true;
		}
		return false;
	}
}
