package level4;

import java.util.Scanner;

public class Main1231_중위순회 {
	public static String[] tree;
	public static String ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			sc.nextLine();

			tree = new String[N + 1];
			ans = "";

			for (int i = 0; i < N; i++) {
				String[] temp = sc.nextLine().split(" ");
				tree[Integer.parseInt(temp[0])] = temp[1];
			}
			inorder(1);
			
			System.out.printf("#%d %s\n", t, ans);
		}

	}

	private static void inorder(int v) {
		if (v >= tree.length) {
			return;
		}

		inorder(2 * v);
		ans += tree[v];
		inorder(2 * v + 1);
	}

}
