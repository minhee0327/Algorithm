package level3;

import java.util.Scanner;

public class Main6057_그래프의삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int cnt = 0;
			
			int matrix[][] = new int[N+1][N+1];
			
			for(int i = 0 ; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				matrix[x][y] = 1;
				matrix[y][x] = 1;
			}

			for(int i = 1; i <= N; i++) {
				for(int j = i+1; j <=N; j++) {
					if(matrix[j][i] == 0) continue;
					for(int k = j+1; k<=N; k++) {
						if(matrix[k][j] == 0) continue;
						if(matrix[i][k] == 0) continue;
						cnt ++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, cnt);
		}
	}

}
