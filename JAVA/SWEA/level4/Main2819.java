package swea.d4;

import java.util.HashSet;
import java.util.Scanner;

public class Main2819 {
    static final int N = 4, X = 7; //N: 격자판 크기, x: 문자열 길이
    static final int[] dx = {1,0,-1,0};
    static final int[] dy = {0,-1,0,1};

    static int[][] matrix;
    static HashSet<String> set;
    static int[] intList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            matrix = new int[N][N];
            set = new HashSet<>();
            intList = new int[X];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            for(int i = 0 ; i < N; i++){
                for(int j = 0; j < N; j++){
                    intList = new int[X];
                    dfs(i, j, 0);
                }
            }
            System.out.printf("#%d %d\n", t, set.size());
        }
    }

    public static void dfs(int x, int y, int cnt) {
        if (cnt == X) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0;  i< X; i++){
                sb.append(intList[i]);
            }
            set.add(sb.toString());
            return;
        }

        if(cnt>X) return;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<= nx && nx < N && 0<= ny && ny < N){
                intList[cnt] = matrix[x][y];
                dfs(nx, ny, cnt+1);
                intList[cnt] = 0;
            }
        }
    }
}
