package level4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1250_하나로 {
	static Node[] island;
	static int N;
	static double E;
	static List<Node> weights;
	static int[] parent;
	static long ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			island = new Node[N];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				island[i] = new Node(sc.nextInt(), 0, 0);
			}
			for (int i = 0; i < N; i++) {
				island[i].y = sc.nextInt();
			}

			E = sc.nextDouble();
			weights = new ArrayList<Node>();

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					weights.add(new Node(i, j, calc(island[i].x, island[i].y, island[j].x, island[j].y)));
				}
			}
			
			Collections.sort(weights);
			parent = new int[N];
			initializeParent();
			
			for(int i = 0; i < weights.size(); i++) {
				if(findRoot(weights.get(i).x) != findRoot(weights.get(i).y)) {
					union(weights.get(i).x, weights.get(i).y);
					ans += weights.get(i).weight;
				}
			}
			
			System.out.printf("#%d %d\n", t, ans);
			
		}
	}
	

	private static void union(int x, int y) {
		x = findRoot(x);
		y = findRoot(y);
		
		if(x!= y) {
			parent[y] = x;
		}
	}


	private static int findRoot(int x) {
		if(parent[x]==x) {
			return x;
		}
		return parent[x] = findRoot(parent[x]);
	}

	private static void initializeParent() {
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	private static double calc(long x, long y, long x2, long y2) {
		return E * Math.pow(Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2)), 2);
	}

}

class Node implements Comparable<Node> {
	int x;
	int y;
	double weight;

	Node(int x, int y, double weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node node) {
		return this.weight > node.weight ? 1 : this.weight == node.weight ? 0 : -1;
	}
}