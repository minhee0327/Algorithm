package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main5948_새샘이의735게임 {
	public static List<Integer> ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t= 1; t <= T; t++) {
			int arr[] = new int[7];
			boolean visited[] = new boolean[7];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			ans = new ArrayList<Integer>();
			//3개 조합 구하여 합한값을 ans에 저장
			combination(arr, visited, 0, 3);
			
			//중복제거후 다시 list로 변환하여 sort
			Set <Integer> hashSet = new HashSet<>(ans);
			List <Integer> list = new ArrayList<>(hashSet);
			Collections.sort(list);
			
			//출력
			System.out.printf("#%d %d\n", t, list.get(list.size()-5));
		}
	}

	private static void combination(int[] arr, boolean[] visited, int dept, int r) {
		if(r == 0) {
			int sumVal = sum(arr, visited);
			ans.add(sumVal);
			return;
		}
		if(dept == arr.length) {
			return;
		}else {
			for(int i = dept; i<arr.length; i++) {
				visited[i] = true;
				combination(arr, visited, i+1, r-1);
				visited[i] = false;
			}
		}
		
	}

	private static int sum(int[] arr, boolean visited[]) {
		int ret = 0;
		for(int i = 0 ; i < arr.length; i++) {
			if(visited[i]) {
				ret += arr[i];
			}
		}
		return ret;
	}
}
