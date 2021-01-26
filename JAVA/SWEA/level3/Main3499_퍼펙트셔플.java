package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3499_퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			List<String> list = new ArrayList<String>();

			list = Shuffle(list, N, sc);

			System.out.printf("#%d ", t);
			for (String s : list) {
				System.out.printf("%s ", s);
			}
			System.out.println();
		}
	}

	private static List<String> Shuffle(List<String> list, int n, Scanner sc) {
		for (int i = 0; i < n / 2; i++) {
			list.add(sc.next());
		}
		
		if (n % 2 != 0) {
			list.add(sc.next());
		}
		
		for (int i = 0; i < n / 2; i++) {
			list.add(i * 2 + 1, sc.next());
		}
		return list;
	}

}
