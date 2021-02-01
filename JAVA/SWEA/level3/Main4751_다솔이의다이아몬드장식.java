package level3;

import java.util.Scanner;

public class Main4751_다솔이의다이아몬드장식 {
	public static String[][] decorate;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String str = sc.next();
			int col = 5 + 4 * (str.length() - 1);
			decorate = new String[5][col];

			fillFirstLast(col);
			fillSecondForth(col);
			fillWord(col, str);

			print();
		}
	}

	private static void print() {
		for (int i = 0; i < decorate.length; i++) {
			for (int j = 0; j < decorate[i].length; j++) {
				System.out.print(decorate[i][j]);
			}
			System.out.println();
		}
	}

	private static void fillWord(int c, String str) {
		for (int i = 0; i < c; i++) {
			if ((i - 2) % 4 == 0) {
				decorate[2][i] = String.valueOf(str.charAt((i - 2) / 4));
			} else if (i % 2 == 0) {
				decorate[2][i] = "#";
			} else {
				decorate[2][i] = ".";
			}
		}
	}

	private static void fillSecondForth(int c) {
		for (int i = 0; i < c; i++) {
			if (i % 2 == 0) {
				decorate[1][i] = ".";
				decorate[3][i] = ".";
			} else {
				decorate[1][i] = "#";
				decorate[3][i] = "#";
			}
		}
	}

	private static void fillFirstLast(int c) {
		for (int i = 0; i < c; i++) {
			if ((i - 2) % 4 == 0) {
				decorate[0][i] = "#";
				decorate[4][i] = "#";
			} else {
				decorate[0][i] = ".";
				decorate[4][i] = ".";
			}
		}
	}

}
