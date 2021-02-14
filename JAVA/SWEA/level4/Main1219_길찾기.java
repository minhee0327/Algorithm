package level4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1219_길찾기 {
	public static List<ArrayList<Integer>> graph;
	public static List <Integer> visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int T = sc.nextInt();
			int n = sc.nextInt();
			
			initGraph();
			visited = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph.get(x).add(y);
			}
			
			dfs(0);
			
			if(visited.contains(99)) {
				System.out.printf("#%d %d\n", t, 1);
			}else {
				System.out.printf("#%d %d\n", t, 0);
			}
		}
	}

	private static void dfs(int v) {
		visited.add(v);
		
		if(v == 99) {
			return;
		}
		if(graph.get(v).isEmpty()) {
			return;
		}
		for(int curV: graph.get(v)) {
			if(!visited.contains(curV)) {
				dfs(curV);
			}
		}
	}

	private static void initGraph() {
		graph = new ArrayList<>();
		for(int i = 0; i < 100; i ++) {
			graph.add(new ArrayList<Integer>());
		}
	}


}
