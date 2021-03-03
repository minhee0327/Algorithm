package programmers.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 섬연결하기 {
	static int[] parent;
	public static void main(String[] args) {
		System.out.println(solution(4, new int[][] {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}}));
	}

	//최소신장트리(크루스칼 구현)
	private static int solution(int n, int[][] costs) {
		int answer = 0;
		
		//initialize parent
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		List <Node> list = new ArrayList<Node>();
		
		for(int i = 0; i < costs.length; i++) {
			list.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
			list.add(new Node(costs[i][1], costs[i][0], costs[i][2]));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			int x = list.get(i).getX();
			int y = list.get(i).getY();
			
			if(find(x)!= find(y)) {
				union(x, y);
				answer += list.get(i).getCost();
			}
		}
		
		return answer;
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y) {
			parent[x] = y;
		}else {
			parent[y] = x;
		}
	}

	private static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

}

class Node implements Comparable<Node>{
	int x;
	int y;
	int cost;
	
	Node(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
	
}