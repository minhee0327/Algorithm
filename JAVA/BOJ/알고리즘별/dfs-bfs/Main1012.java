package boj.bfs;

import java.util.Scanner;

//유기농 배추
public class Main1012 {
    static int[][] matrix;
    static int N, M, K, cnt;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            cnt = 0;
            matrix = new int[N][M];
            visited = new boolean[N][M];

            for (int k = 0; k < K; k++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                matrix[x][y] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && matrix[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && matrix[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }

    }
}
