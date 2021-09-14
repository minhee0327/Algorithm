package boj.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main7562 {
    static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    static int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};
    static int[][] chess;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            chess = new int[n][n];
            int cx = sc.nextInt();
            int cy = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();

            search(cx, cy, rx, ry, n);
            System.out.println(chess[rx][ry]);
        }

    }

    private static int search(int cx, int cy, int rx, int ry, int n) {
        Queue<XY> q = new LinkedList<>();
        q.add(new XY(cx, cy));

        while(!q.isEmpty()){
            var xy = q.poll();

            if (xy.x == rx && xy.y == ry) {
                return chess[rx][ry] - 1;
            }

            for (int i = 0; i < 8; i++) {
                int nx = xy.x + dx[i];
                int ny = xy.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || chess[nx][ny] != 0) continue;

                chess[nx][ny] = chess[xy.x][xy.y] + 1;
                q.add(new XY(nx, ny));
            }

        }
        return 0;
    }

}

class XY{
    int x;
    int y;

    XY(int x, int y){
        this.x = x;
        this.y = y;
    }
}