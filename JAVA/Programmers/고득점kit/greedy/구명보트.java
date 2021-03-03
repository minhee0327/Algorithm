package programmers.greedy;

import java.util.*;

public class 구명보트 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{70, 50,80,50}, 100));
		System.out.println(solution(new int[]{70, 80, 50}, 100));
	}
	
	public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lastIdx = people.length-1;
        for(int i = 0; i <= lastIdx; i++, answer++) {
        	while (lastIdx>i && people[i] + people[lastIdx--] > limit) {
        		answer++;
        	}
        }
        return answer;
    }
}
