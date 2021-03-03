package programmers.sort;

import java.util.*;

public class K번째수 {

	public static void main(String[] args) {
		int array[] = { 1, 5, 2, 6, 3, 7, 4 };
		int commands[][] = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		System.out.println(Arrays.toString(solution(array, commands)));
		System.out.println(Arrays.toString(solution2(array, commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] ans = new int[commands.length];
		
		for(int i = 0; i <commands.length; i++) {
			List <Integer> list = new ArrayList<Integer>();
			for(int j = commands[i][0]-1; j < commands[i][1]; j++) {
				list.add(array[j]);
			}
			Collections.sort(list);
			ans[i] = list.get(commands[i][2]-1);
		}
		return ans;
	}
	
	//copyOfRange라는 method를 첨 봐서 활용해봄.
	public static int[] solution2(int[] array, int[][] commands) {
		int ans[] = new int[commands.length];
		
		for(int i = 0; i <commands.length; i++) {
			int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(temp);
			ans[i] = temp[commands[i][2]-1];
		}
		
		return ans;
	}
}
