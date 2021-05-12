package programmers.level2;

import java.util.Stack;

//올바른 괄호
public class Sol12 {
    public static void main(String[] args) {
        System.out.println(new Solution12().solution("()()"));
        System.out.println(new Solution12().solution("(())()"));
        System.out.println(new Solution12().solution(")()("));
        System.out.println(new Solution12().solution("(()("));
    }
}

class Solution12{
    // stack 을 활용한 풀이 (내 접근 시도)
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char str = s.charAt(i);
            if(str =='('){
                stack.add(str);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else if(stack.peek() != str){
                    stack.pop();
                }else{
                    stack.add(str);
                }
            }

            if(stack.size()>s.length()-i) break;
        }
        return stack.isEmpty();
    }

    // stack count 로 구현
    boolean solution2(String s){
        int cnt = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                cnt++;
            }else if(c == ')'){
                cnt--;
            }
            if(cnt < 0){
                return false;
            }
        }
        return cnt == 0;
    }
}