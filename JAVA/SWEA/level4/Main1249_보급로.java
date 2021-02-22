package level4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1249_보급로 {
	public static int[][] matrix;
	public static int[][] ans;
	public static boolean[][] visited;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, -1, 0, 1 };
	public static int min, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			//초기화
			matrix = new int[N + 1][N + 1];
			ans = new int[N + 1][N + 1];
			visited = new boolean[N + 1][N + 1];
			min = Integer.MAX_VALUE;
			initailizeAns();
			
			//입력
			for (int i = 1; i <= N; i++) {
				String temp = sc.next();
				for (int j = 1; j <= N; j++) {
					matrix[i][j] = temp.charAt(j-1) - '0';
				}
			}
			
			//bfs entry point
			ans[1][1] = 0;
			bfs(1, 1);

			System.out.printf("#%d %d\n",t, ans[N][N]);
		}
	}

	private static void initailizeAns() {
		for(int i = 1; i <=N; i++) {
			for(int j = 1; j <= N; j++) {
				ans[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private static void bfs(int x, int y) {
		Queue <Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int cx = p.x;
			int cy = p.y;
			
			if(cx == N && cy == N) {
				if(min > ans[cx][cy]) {
					min = ans[cx][cy];
				}
			}
			if(min <= ans[cx][cy]) continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(0<nx && nx<=N && 0<ny && ny<=N) {
					if(!visited[nx][ny] ||ans[nx][ny] > ans[cx][cy] + matrix[nx][ny]) {
						visited[nx][ny] = true;
						ans[nx][ny] = ans[cx][cy] + matrix[nx][ny];
						q.offer(new Pos(nx, ny));
					}
				}
			}
		}
	}

}

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}