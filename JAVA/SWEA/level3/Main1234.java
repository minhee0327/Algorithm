package swea.d3;

import java.util.Scanner;
import java.util.Stack;

public class Main1234 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            int n = sc.nextInt();
            String m = sc.next();
            StringBuilder answer = new StringBuilder();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < n; i++){
                char nxt = m.charAt(i);
                if(stack.isEmpty() || stack.peek() != nxt){
                    stack.push(nxt);
                }else if(stack.peek() == nxt){
                    stack.pop();
                }
            }

            while (!stack.isEmpty()){
                answer.append(stack.pop());
            }

            answer.reverse();

            System.out.printf("#%d ", t+1);
            System.out.println(answer);
        }
    }
}
