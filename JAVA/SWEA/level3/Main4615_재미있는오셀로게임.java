package level3;

import java.util.Scanner;

public class Main4615_재미있는오셀로게임 {
	public static int[][] matrix;
	public static int N;
	public static int blackCnt, whiteCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			matrix = new int[N][N];

			initializeMatrix();

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int bw = sc.nextInt();
				matrix[x][y] = bw;
				changeMatrix(x, y, bw);
			}

			countBlackAndWhite();

			System.out.printf("#%d %d %d\n", t, blackCnt, whiteCnt);

		}
	}

	private static void countBlackAndWhite() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1)
					blackCnt++;
				else if (matrix[i][j] == 2)
					whiteCnt++;
			}
		}
	}

	private static void changeMatrix(int x, int y, int bw) {

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0)
					continue;

				int nx = x + i;
				int ny = y + j;

				boolean flag = false;

				while (0 <= nx && nx < N && 0 <= ny && ny < N && matrix[nx][ny] != 0) {
					// 지금 놓은 색과 같은 값이 나오면, 반복문 중지.
					if (matrix[nx][ny] == bw) {
						flag = true;
						break;
					}
					// 현재 확인하고자 하는 방향으로 증가시켜줌.
					nx += i;
					ny += j;
				}

				// flag가 true인 경우는 현재 놓은 색과 간격을 두고 같은 색이 있는경우이므로 반복문을 돌아야함.
				// nx, ny로부터 기존에 x, y 까지 움직이면서 뒤집어주고
				// nx, ny 가 x, y까지 오면 사이의 돌들을 다 확인한 거니까 반복 중지
				while (flag) {
					if (nx == x && ny == y)
						break;
					matrix[nx][ny] = bw;
					nx -= i;
					ny -= j;
				}

			}
		}
	}

	private static void initializeMatrix() {
		matrix[N / 2 - 1][N / 2 - 1] = 2;
		matrix[N / 2 - 1][N / 2] = 1;
		matrix[N / 2][N / 2] = 2;
		matrix[N / 2][N / 2 - 1] = 1;

		blackCnt = 0;
		whiteCnt = 0;
	}

}
