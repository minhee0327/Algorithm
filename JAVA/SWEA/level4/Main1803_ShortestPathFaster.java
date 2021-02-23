package level4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main1803_ShortestPathFaster {
	public static final int INF = Integer.MAX_VALUE;
	static int N, M, S, E;
	static List<ArrayList<Node1>> graph;
	static long[] weights;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			S = sc.nextInt();
			E = sc.nextInt();
			weights = new long[N+1];
			
			graph = new ArrayList<ArrayList<Node1>>();
			
			for(int i = 0; i <= N; i++) {
				graph.add(new ArrayList<Node1>());
			}
			
			for(int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int w = sc.nextInt();
				
				graph.get(x).add(new Node1(y, w));
				graph.get(y).add(new Node1(x, w));
			}
			
			dijkstra(S, t);
		}
	}
	private static void dijkstra(int start, int t) {
		Queue <Node1>q = new PriorityQueue<>();
		boolean [] visited = new boolean[N+1];
		q.offer(new Node1(start,0));
		
		while(!q.isEmpty()) {
			Node1 node = q.poll();
			
			if(visited[node.index]) continue;
			visited[node.index] = true;
			if(node.index == E) {
				System.out.printf("#%d %d\n", t, node.wieght);
				break;
			}
			ArrayList<Node1> list = graph.get(node.index);
			for(Node1 a : list){
                q.add(new Node1(a.index,node.wieght+a.wieght));
            }
		}
	}
}

class Node1 implements Comparable<Node1>{
	int index;
	long wieght;
	
	Node1(int index, long weight){
		this.index = index;
		this.wieght = weight;
	}

	@Override
	public int compareTo(Node1 o) {
		return Long.compare(wieght, o.wieght);
	}
}