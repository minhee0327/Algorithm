package aloneBook.search;

import java.util.Scanner;

//p.149 음료수 얼려먹기
public class Practice01 {
    public static int n , m, cnt;
    public static int[][] arr;
    public static boolean[][] visited;
    public static final int ICE = 0;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            char[] temp = sc.next().toCharArray();
            for(int j = 0; j < m; j++){
                arr[i][j] = temp[j] - '0';
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == ICE && !visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<= nx && nx< n && 0<= ny && ny<m && !visited[nx][ny] && arr[nx][ny] ==ICE){
                dfs(nx, ny);
            }
        }

    }
}
