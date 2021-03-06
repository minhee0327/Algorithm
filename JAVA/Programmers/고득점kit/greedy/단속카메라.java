package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}));
		System.out.println(solution2(new int[][] {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}));
	}

	private static int solution(int[][] routes) {
		//진출 지점을 기준으로 정렬
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		
		int cnt = 0;
		int min = Integer.MIN_VALUE;

		for(int r[]: routes) {
			if(min<r[0]) {
				min = r[1];
				cnt++;
			}
		}
		
		return cnt;
	}
	
	private static int solution2(int[][] routes) {
		Arrays.sort(routes, (a, b) -> Integer.compare(a[0], b[0]));
		
		int min = routes[0][0];
		int max = routes[0][1];
		//첫번째는 무조건 세우는걸로 기준 
		int cnt = 1;
		
		for(int i = 1; i < routes.length; i++) {
			int in = routes[i][0];
			int out = routes[i][1];
			
			if(min>out || max<in) {
				cnt ++;
				min = in;
				max = out;
			}else {
				min = min > in ? min: in;
				max = max < out? max: out;
			}
		}
		
		return cnt;
	}
	
}
