package programmers.dfsbfs;

public class Network {

	public static void main(String[] args) {
		System.out.println(solution( 3, new int[][] {{1,1,0}, {1,1,0}, {0,0,1}}));
		System.out.println(solution( 3, new int[][] {{1,1,0}, {1,1, 1}, {0,1,1}}));
	}
	static boolean visited[][];
	public static int solution(int n , int[][] computers) {
		visited = new boolean[n][n];
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i][i]) {
				dfs(i, n, computers);
				answer ++;
			}
		}
		return answer;
	}
	
	
	public static void dfs(int row, int n, int[][]computers) {
		for(int i = 0; i < n; i ++) {
			if(!visited[row][i]&& computers[row][i] == 1) {
				visited[row][i] = true;
				visited[i][row] = true;
				dfs(i, n, computers);
			}
		}
	}
}
