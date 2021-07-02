package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//카카오 프렌즈 컬러링북
public class Sol43_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution43_1().solution(6, 4, new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        })));
    }
}

class Solution43_1 {
    int w, h, cnt;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    boolean[][] visited;
    int[][] picture;

    public int[] solution(int m, int n, int[][] picture) {
        h = m;
        w = n;
        cnt = 0;
        this.picture = picture;
        visited = new boolean[h][w];

        int[] answer = new int[2];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    visited[i][j] = true;
                    cnt = 1;
                    bfs(picture[i][j], i, j);
                    answer[1] = Math.max(cnt, answer[1]);
                    answer[0]++;
                }
            }
        }

        return answer;
    }

    public void bfs(int e, int x, int y) {
        Queue<Node43> queue = new LinkedList<>();
        queue.add(new Node43(x, y));

        while(!queue.isEmpty()){
            Node43 node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny]) continue;
                if (e == picture[nx][ny]) {
                    visited[nx][ny] = true;
                    cnt++;
                    queue.add(new Node43(nx, ny));
                }
            }
        }

    }

}

class Node43 {
    int x;
    int y;

    Node43(int x, int y) {
        this.x = x;
        this.y = y;
    }
}