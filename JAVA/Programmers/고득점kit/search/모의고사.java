package programmers.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
	static int problem = 10000;
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(solution(new int[] { 1, 3, 2, 4, 2 })));
	}

	private static int[] solution(int[] answers) {
		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int cnt[] = {0, 0, 0};
		int personsCnt = 3;
		
		for(int i = 0; i < answers.length; i++) {
			if(p1[i%p1.length] == answers[i]) {
				cnt[0]++; 
			}
			if(p2[i%p2.length] == answers[i]) {
				cnt[1]++; 
			}
			if(p3[i%p3.length] == answers[i]) {
				cnt[2]++; 
			}
		}
		int max = 0;
		for(int i = 0; i < personsCnt; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
			}
		}
		
		List <Integer> list = new ArrayList<Integer>();
		
		for(int i = 0 ; i < cnt.length; i++) {
			if(max == cnt[i]) {
				list.add(i+1);
			}
		}
		
		if(list.size() == 1) {
			return new int[] {list.get(0)};
		}else {
			int ret[] = new int[list.size()];
			for(int i = 0; i < list.size(); i++) {
				ret[i] = list.get(i);
			}
			Arrays.sort(ret);
			return ret;
		}
	}
}
