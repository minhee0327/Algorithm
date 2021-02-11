package level4;

import java.util.Scanner;

public class Main1211_Ladder2 {
	public static int[][] ladder = new int[100][100];
	public static boolean[][] visited = new boolean[100][100];
	public static int n = 100; //ladder의 가로, 세로 크기
	public static Scanner sc = new Scanner(System.in);
	public static int dir[][] = {{0,1},{0,-1}, {1,0}};
	public static int minLen, ans;
	public static void main(String[] args) {
		
		for(int t = 1; t <= 10; t++) {
			int T = sc.nextInt();

			initLadder();
			minLen = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				if(ladder[0][i] == 1) {
					countLenth(0, i);
				}
			}
			System.out.printf("#%d %d\n", t , ans);
		}
	}
	
	
	
	private static void countLenth(int x, int y) {
		int sy = y;
		int cnt = 0;
		initVisited();
		while(x<99) {
			for(int i = 0; i < dir.length; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if(0 <= nx && nx < n && 0 <= ny && ny<n && ladder[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					x = nx;
					y = ny;
					cnt ++;
				}
			}
		}
		
		if(cnt <= minLen) {
			minLen = cnt;
			ans = sy;
		}
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
