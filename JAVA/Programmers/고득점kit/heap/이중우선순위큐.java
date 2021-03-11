package programmers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"I 16","D 1"})));
		System.out.println(Arrays.toString(solution(new String[] {"I 7","I 5","I -5","D -1"})));
	}

	public static int[] solution (String[] operations) {
		List <Integer> list = new LinkedList<>();
		
		for(int i = 0; i < operations.length; i++) {
			StringTokenizer st = new StringTokenizer(operations[i]);
			char opt = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			
			if(opt == 'I') {
				list.add(num);
			}else {
				Collections.sort(list);
				if(list.size()<=0) {
					continue;
				}
				
				if(num == 1) {
					list.remove(list.size()-1);
				}else if (num == -1) {
					list.remove(0);
				}
			}
		}
		
		if(list.isEmpty()) {
			return new int[] {0,0};
		}else {
			Collections.sort(list);
			return new int[] {list.get(list.size()-1), list.get(0)};
		}
	}
}
