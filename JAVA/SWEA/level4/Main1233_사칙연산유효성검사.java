package level4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1233_사칙연산유효성검사 {
	public static List<String> tree;
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int N = sc.nextInt();
			sc.nextLine();

			tree = new ArrayList<String>();
			tree.add("emptyVal");

			sb = new StringBuilder();

			// tree idx 위치에 data 를 넣어준다. (child node 정보는 담지 않음)
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());

				int idx = Integer.parseInt(st.nextToken());
				String data = st.nextToken();
				tree.add(idx, data);

				while (st.hasMoreTokens()) {
					st.nextToken();
				}
			}

			// 중위 순회로 계산해야하는 문자열을 만들어준다.
			order(1);

			// 유효성 검증을 한다.
			boolean flag = true;
			int p = 0, q = p + 1;

			while (p < sb.length() - 1) {
				if (!flag)
					break;
				int num = sb.charAt(p) - '0';
				if (0 <= num && num <= 9) {
					char opt = sb.charAt(q);
					if ("+-*/".contains(String.valueOf(opt))) {
						p += 2;
					} else {
						flag = false;
					}
				} else {
					flag = false;
				}
			}

			System.out.printf("#%d %d\n", t, flag ? 1 : 0);
		}
	}

	private static void order(int v) {
		if (tree.size() <= v)
			return;

		order(v * 2);
		sb.append(tree.get(v));
		order(v * 2 + 1);
	}

}
