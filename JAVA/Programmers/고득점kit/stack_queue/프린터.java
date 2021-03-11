package programmers.stackQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프린터 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 1, 3, 2 }, 2));
		System.out.println(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
	}

	public static int solution(int[] priorities, int location) {
		List<Integer> list = new ArrayList<>();
		Queue<Tuple> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			list.add(priorities[i]);
			q.add(new Tuple(priorities[i], i));
		}

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});

		int i = 0, cnt = 1;
		while (i < priorities.length) {
			int maxPriority = list.get(i);
			if (maxPriority == q.peek().priority && location == q.peek().idx) {
				i++;
				break;
			} else if (maxPriority == q.peek().priority && location != q.peek().idx) {
				i++;
				q.poll();
			} else {
				q.add(q.poll());
				continue;
			}
			cnt++;
		}
		return cnt;
	}
}

class Tuple {
	int priority;
	int idx;

	Tuple(int priority, int idx) {
		this.priority = priority;
		this.idx = idx;
	}
}


/*
 * [내코드 풀이- 나중에 잊을 나를 위해]
 * 1. ArrayList에 priorities들을 담고, 내림차 정렬을 한다. (우선순위 높은것 -> 낮은것 순)
 * 	- 우선순위에 따라 pop을 결정하기 위해 둠.
 * 
 * 2. 우선순위 일치여부와 위치 일치여부에 따라 값 변경
 * 	2-1. list에 담긴 우선순위와 queue에 담긴 우선순위가 일치하고, 현재 위치가 찾고자하는 위치(location)과 일치하면 반복문 종료
 * 	2-2. list에 담긴 우선순위와 queue에 담긴 우선순위가 일치하고, 현재 위치가 찾고자하는 위치(location)과 일치하지 않으면 poll 
 * 	2-3. 나머지 경우는 맨 뒤로가서 자기 차례가 되야하므로 q.add(q.poll())해주고, 출력되지 않았으니까, count하지 않게 continue함.
 */