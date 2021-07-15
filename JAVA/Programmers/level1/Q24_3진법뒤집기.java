package programmers.level1;

public class Q24_3진법뒤집기 {
    public static void main(String[] args) {
        System.out.println(new Solution24().solution(45));
        System.out.println(new Solution24().solution(125));
    }
}

class Solution24 {
    public int solution(int n) {
        String s = change(n);
        return Integer.parseInt(s, 3);
    }

    public String change(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % 3);
            num /= 3;
        }

        return sb.toString();
    }
}