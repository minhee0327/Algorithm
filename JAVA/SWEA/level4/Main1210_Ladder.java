package level4;

import java.util.Scanner;

public class Main1210_Ladder {
	public static int[][] ladder = new int[100][100];
	public static boolean[][] visited = new boolean[100][100];
	public static int n = 100; //ladder의 가로, 세로 크기
	public static Scanner sc = new Scanner(System.in);
	public static int dir[][] = {{0,-1}, {0,1},{-1,0}};
	
	public static void main(String[] args) {
		
		for(int t = 1; t <= 10; t++) {
			int T = sc.nextInt();

			initLadder();
			initVisited();
			
			int x = 99;
			//마지막 row의 값이 2인 열 idx 를 찾기
			int y = findStartIdx();
			
			while(x>0) {
				for(int i = 0; i < dir.length; i++) {
					int nx = x + dir[i][0];
					int ny = y + dir[i][1];
					
					if(0 <= nx && nx < n && 0 <= ny && ny<n && ladder[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						x = nx;
						y = ny;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t , y);
		}
	}
	
	private static int findStartIdx() {
		int ret = -1;
		for(int i = 0; i < n; i++) {
			if(ladder[n-1][i] == 2) {
				ret = i;
			}
		}
		return ret;
	}

	private static void initLadder() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ladder[i][j] = sc.nextInt();
			}
		}
	}
	private static void initVisited() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
	}

}
