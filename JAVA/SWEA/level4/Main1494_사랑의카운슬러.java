package level4;

import java.util.Scanner;

public class Main1494_사랑의카운슬러 {
	static int [][]warm;
	static int N;
	static boolean[] visited;
	static long ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			visited = new boolean[N+1];
			warm = new int[N+1][2];
			ans = Long.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				warm[i][0] = sc.nextInt();
				warm[i][1] = sc.nextInt();
			}
			dfs(0, 0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static void dfs(int idx, int cnt) {
		// 모든 지렁이가 짝이 지어진 경우 Vector값을 계산 후 반환
		if(cnt == N/2) {
			long x = 0; long y = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					x += warm[i][0];
					y += warm[i][1];
				}else {
					x -= warm[i][0];
					y -= warm[i][1];
				}
			}
			ans = Math.min(ans, x*x + y*y);
			return;
		}
		
		
		for(int i = idx; i <N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			dfs(i+1, cnt+1);
			visited[i] = false;
		}
	}
	

}


/*
 * 문제가 이해 안되서 풀이를 보고 이해가 됬다.. 다음엔 맞추자..!
 * 
 * 1. 총 N마리의 지렁이가 있었다면 => 2/N 의 쌍이 지어진다.
 * 2. 이때 Vector의 합은 (도착지점의 x 좌표의 합 - 시작점의 x 좌표의 합, 도착지점의 y 좌표의 합 - 시작점의 y 좌표의 합) 으로 구성된다.
 * 3. 2에서 도착점, 출발점으로 나누어 V(x,y)를 구한 뒤, 최소값을 구해서 갱신. 
 */