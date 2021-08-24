package programmers.monthly;

//weekly problem
public class Day01 {
    public static void main(String[] args) {
        System.out.println(new Solution1().solution(3, 20, 4));
    }
}

class Solution1{
    public long solution(int price, int money, int count) {
        long answer = price * ((long) (count) * (count+1) / 2 ) - money;
        return answer > 0 ? answer : 0;
    }
}