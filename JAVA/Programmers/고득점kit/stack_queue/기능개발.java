package programmers.stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{93, 30, 55},new int[]{1, 30, 5} )));
		System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99},new int[]{1, 1, 1, 1, 1, 1} )));
		System.out.println(Arrays.toString(solution(new int[]{40, 93, 30, 55, 60, 65},new int[]{60, 1, 30, 5 , 10, 7} )));
		System.out.println(Arrays.toString(solution(new int[]{93, 30, 55, 60, 40, 65},new int[]{1, 30, 5 , 10, 60, 7} )));
	}
	
	public static int[] solution(int[] progresses, int[] speeds){
		Queue <Integer> q = new LinkedList<>();
		
		for(int i = 0; i < speeds.length; i++) {
			if(((100 - progresses[i])) % speeds[i] != 0) {
				progresses[i] = (100 - progresses[i])/speeds[i] + 1;
			}else {
				progresses[i] = (100 - progresses[i]) / speeds[i];
			}
			q.add(progresses[i]);
		}
		
		List <Integer> tempCnt = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int pivot = q.poll();
			int cnt = 1;
			while (!q.isEmpty() && pivot >= q.peek()) {
				q.poll();
				cnt ++;
			}
			tempCnt.add(cnt);
		}
		
		int[] answer = new int[tempCnt.size()];
		
		for(int i = 0; i < answer.length; i++) {
			answer[i] = tempCnt.get(i);
		}
		
        return answer;
	}
}


/*
 * [실수한 부분]
 * 1. 남은 progresses에서 끝낼 수 있는 시간을 구할 때, % 값을 이상하게 계산했었음..
 * 2. poll()할때, 항상 비어있는지 유무 체크할 것.
 * 
 */
 