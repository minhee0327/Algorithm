package level4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1258_행렬찾기 {
	static int[][] matrix;
	static boolean[][] visited;
	static int cnt;
	static List<Rect> xy;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			matrix = new int[N+1][N+1];
			visited = new boolean[N+1][N+1];
			xy = new ArrayList<>();
			cnt = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			//행렬이 하나 존재할 때마다 cnt증가 & dfs돌면서 r,c,넓이 구하여 xy list에 담기.
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && matrix[i][j] != 0) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			
			//넓이를 기준으로 정렬을 하고, 같은 경우엔 행을 기준으로 정렬하기
			Collections.sort(xy);
			
			//c출력
			System.out.printf("#%d %d ", t, cnt);
			for(Rect r: xy) {
				System.out.printf("%d %d ", r.x, r.y);
			}
			System.out.println();
		}
	}

	private static void dfs(int x, int y) {
		int r = 0;
		int c = 0;

		while (matrix[x+r][y] != 0) {
			r+=1;
		}
		while(matrix[x][y+c]!= 0) {
			c+=1;
		}
		
		xy.add(new Rect(r*c, r, c));
		for(int i = x; i < x+r; i++) {
			for(int j = y; j < y+c; j++) {
				visited[i][j] = true;
				matrix[i][j] = 0;
			}
		}
		
	}

}

class Rect implements Comparable<Rect>{
	int x;
	int y;
	int size;
	
	Rect(int size, int x, int y){
		this.size = size;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Rect o) {
		return this.size > o.size? 1: this.size < o.size?-1:this.x-o.x;
	}
}

/*
 * 내가 실수했던 부분 (생각하는 시간이 걸린 부분)
 * 1. 행렬의 사이즈가 같을 때, 행을 기준으로 정렬할 것.
 * 2. 방문여부에 따라서 dfs돌렸었는데, 중요한 matrix의 정보를 체킹하지 않았던 것.
 * 3. r, c 길이를 어떻게 구할지
 * 
 * 처음에 dx, dy 방향벡터로 접근을 할 까 했다가, 문제에서 답을 요구하는건 2가지였기 때문에 4방향 탐색보다 r,c값을 먼저 얻기로 접근했다.
 * 그래서 r, c값과 넓이를 저장하고, 해당 submatrix(부속 행렬)의 정보는 방문했고, matrix도 한번더 0으로 만들어줬다.
 * 이후 정렬을 수행하고 출력함.
 */
