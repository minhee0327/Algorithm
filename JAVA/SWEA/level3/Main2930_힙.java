package level3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main2930_힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			Queue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

			for (int i = 0; i < N; i++) {
				int opt = sc.nextInt();
				if (opt == 1) {
					int x = sc.nextInt();
					heap.add(x);
				} else {
					if (heap.isEmpty()) {
						sb.append("-1 ");
					} else {
						sb.append(heap.poll() + " ");
					}
				}
			}

			System.out.printf("#%d %s\n", t, sb.toString());
		}
	}
}


