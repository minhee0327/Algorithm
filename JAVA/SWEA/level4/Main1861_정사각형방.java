package level4;

import java.util.Scanner;

public class Main1861_정사각형방 {
	static int matrix[][];
	static boolean visited[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int N, tempCnt, maxCnt;
	static int cntArr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			matrix = new int[N][N];
			cntArr = new int[N][N];
			maxCnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			// 모든 점을 확인해서, 각 지점에서 가장 최대 길이를 cntArr에 담는다. 
			// 또한 가장 큰 길이 정보를 담는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					tempCnt = 0;
					dfs(i, j, 1);
					cntArr[i][j] = tempCnt;
					if(maxCnt<cntArr[i][j]) {
						maxCnt = cntArr[i][j];
					}
				}
			}
			
			// 가장 큰 길이 정보에 해당하는 값들중 가장 작은 값을 찾아 출력한다.
			int ans = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(cntArr[i][j] == maxCnt) {
						if (ans>matrix[i][j]) {
							ans = matrix[i][j];
						}
					}
				}
			}
			
			System.out.printf("#%d %d %d\n", t, ans, maxCnt);
			
		}
	}

	private static void dfs(int x, int y, int cnt) {
		if(tempCnt < cnt) {
			tempCnt = cnt;
		}
		for(int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 <= nx && nx < N 
				&& 0<= ny && ny < N 
				&& !visited[nx][ny] 
				&& matrix[nx][ny] == matrix[x][y]+1) {
				visited[nx][ny] = true;
				cnt+= 1;
				dfs(nx, ny, cnt);
				cnt-=1;
				visited[nx][ny] = false;
			}
		}
		
	}

}
