package programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class O27_폰켓몬 {
    public static void main(String[] args) {
        System.out.println(new Solution27().solution(new int[] {3,1,2,3}));
        System.out.println(new Solution27().solution(new int[] {3,3,3,2,2,4}));
        System.out.println(new Solution27().solution(new int[] {3,3,3,2,2,2}));
    }
}

class Solution27{
    public int solution(int[] nums){
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int len = nums.length / 2;
        if(len > set.size()){
            answer = set.size();
        }else{
            answer = len;
        }

        return answer;
    }
}