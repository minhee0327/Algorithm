package programmers.level2;

import java.util.Arrays;

//N 개의 최소공배수
public class Sol1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().solution(new int[]{2,6,8,14}));
        System.out.println(new Solution1().solution(new int[]{1,2,3}));
    }
}

class Solution1{
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int lcm = arr[0];
        for(int i = 1; i < arr.length; i++){
            lcm = lcm(lcm, arr[i]);
        }
        return lcm;
    }

    public int gcd(int a, int b){
        while(b> 0){
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public int lcm (int a, int b){
        return a*b/gcd(a, b);
    }
}