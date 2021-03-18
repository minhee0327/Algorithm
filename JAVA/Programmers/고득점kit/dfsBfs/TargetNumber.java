package programmers.dfsbfs;

public class TargetNumber {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,1,1,1,1}, 3));
	}

	static int answer;
	public static int solution(int[] number, int target) {
		answer = 0;
		dfs(number, target, 0, 0);
		return answer;
	}
	private static void dfs(int[] number, int target, int idx, int sum) {
		if(idx == number.length) {
			if(sum == target) {
				answer++;
			}
			return;
		}
		
		dfs(number, target, idx+1, sum + number[idx]);
		dfs(number, target, idx+1, sum - number[idx]);
	}
	
}
