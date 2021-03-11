package programmers.heap;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
		System.out.println(solution2(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue <Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
        	pq.add(scoville[i]);
        }
        
        while(pq.size() > 1) {
        	Iterator<Integer> itr = pq.iterator();
        	boolean flag = true;
        	
        	while(itr.hasNext()) {
        		if(itr.next() < K) {
        			flag = false;
        			break;
        		}
        	}
        	
        	if(flag) {
        		break;
        	}
        	
        	int first = pq.poll();
        	int second = pq.poll();
        	
        	pq.add(first + second *2);
        	answer++;
        }
        
        if(!pq.isEmpty() && pq.size() <=1 && pq.poll() < K) {
        	return -1;
        }
        return answer;
    }
	
	public static int solution2(int[] scoville, int K) {
        int answer = 0;
        
        Queue <Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
        	pq.add(scoville[i]);
        }
        while(pq.size() > 1 && pq.peek() < K) {
        	int first = pq.poll();
        	int second = pq.poll();
        	
        	pq.add(first + second *2);
        	answer++;
        }
        if(pq.size() <=1 && pq.peek() < K) {
        	return -1;
        }
        return answer;
	}
}

/* [solution1]
 * - 나는 모든 scovile지수를 확인하기 위해 Iterator를 두고 모두 확인을 했는데
 * - Priority queue의 특성을 생각해보면, 맨 첫번째값이 K보다 크기만 하면 이후 모든 값들도 K보다 큰 거니까 
 * - iterator를 두고 구현할 필요는 없었던 것 같다.
 * 
 * [solution2] 
 * - iterator제거하고, 첫번째 값만 비교해서 구현해봐야겠다.
 * - 반복이 더 줄어서 효율도 더 늘어났다고 생각했는데;;속도 차이가 크지 않았음. 
 */
