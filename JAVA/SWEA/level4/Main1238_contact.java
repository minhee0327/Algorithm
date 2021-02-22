package level4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1238_contact {
	public static int graph[][];
	public static int visited[];
	public static int maxCnt, N, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			int start = sc.nextInt();
			sc.nextLine();
			String temp = sc.nextLine();
			StringTokenizer st = new StringTokenizer(temp);
			
			graph = new int[N+1][N+1];
			visited = new int[N+1];
			
			maxCnt = 0;
			ans = 0;
			
			while(st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
			}
			bfs(start);
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	
	public static void bfs(int v) {
		Queue <Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = 1;
		
		// 방문 거리를 계산하는 반복문
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 1; i <= N; i++) {
				//가는 길이 있 있고, 방문한적도 없는 경우에는 현재노드에 방문cnt보다 하나 높혀줌. 
				if(graph[cur][i] == 1 && visited[i]== 0) {
					visited[i] = visited[cur] + 1;
					q.offer(i);
				}
			}
			
			maxCnt = visited[cur] ;
		}
		
		//방문 거리 배열(visited)를 탐색하면서, maxCnt 와 같은 경우
		for(int i = 0; i <= N ; i++) {
			if(maxCnt == visited[i]) {
				if(ans < i) {
					ans = i;
				}
			}
		}
	}
}
