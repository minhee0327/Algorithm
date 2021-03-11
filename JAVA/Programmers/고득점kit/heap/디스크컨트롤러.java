package programmers.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
	}

	public static int solution(int[][] jobs) {
		LinkedList <Job> waitQ = new LinkedList<>();
		PriorityQueue <Job> runQ = new PriorityQueue<>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return Integer.compare(o1.processingTime, o2.processingTime);
			}
			
		});
		
		for(int i = 0; i < jobs.length; i++) {
			waitQ.add(new Job(jobs[i][0], jobs[i][1]));
		}
		
		Collections.sort(waitQ, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return Integer.compare(o1.requestTime, o2.requestTime);
			}
		});
		
		int cnt = 0; 
		int responseTime = 0;
		int time = waitQ.peek().requestTime;
		
		while(cnt < jobs.length) {
			while(!waitQ.isEmpty() && waitQ.peek().requestTime <= time) {
				runQ.add(waitQ.poll());
			}
			
			if(!runQ.isEmpty()) {
				Job j = runQ.poll();
				time += j.processingTime;
				responseTime += time - j.requestTime;
				cnt++;
			}else {
				time++;
			}
			
		}
		return responseTime/cnt;
	}

}

class Job {
	int requestTime; // 요청시간
	int processingTime;// 소요시간(처리시간)

	Job(int requestTime, int processingTime) {
		this.requestTime = requestTime;
		this.processingTime = processingTime;
	}
}

/*참조했음.... 링크: https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%94%94%EC%8A%A4%ED%81%AC-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC-Java*/
