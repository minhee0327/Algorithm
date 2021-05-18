package aloneBook.implement;

import java.util.Scanner;

public class Practice2 {
    public static final int[] dx = { -1,0, 1, 0}; // u,r,d,l
    public static final int[] dy = {0,1, 0, -1};
    public static final int SEA = 1, FEIlD =0;
    public static int x, y, dir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();
        dir = sc.nextInt();

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0, turn_time = 0;
        while(true){
            turnLeft();

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(0<=nx && nx<n && 0<= ny && ny<m &&map[nx][ny] == FEIlD && !visited[nx][ny]){
                visited[nx][ny] = true;
                x = nx;
                y = ny;
                cnt++;
                turn_time = 0;
                continue;
            }else{
                turn_time++;
            }

            if(turn_time ==4){
                nx = x - dx[dir];
                ny = y -dy[dir];

                if(map[nx][ny] == FEIlD){
                    x = nx;
                    y = ny;
                }else{
                    break;
                }

                turn_time = 0;
            }

        }
        System.out.println(cnt);

    }

    public static void turnLeft(){
        dir--;
        if(dir == -1){
            dir = 3;
        }
    }
}
