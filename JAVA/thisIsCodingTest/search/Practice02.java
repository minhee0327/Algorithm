package aloneBook.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice02 {
    public static int n, m, x, y;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int answer;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = 0;
        y = 0;

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] temp = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp[j] - '0';
            }
        }
        int answer = bfs(x, y);
        System.out.println(answer);
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while(!q.isEmpty()){
            Node node = q.poll();
            //꺼낸 노드의 현재 위치
            int cx = node.x;
            int cy = node.y;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(0<=nx && nx < n && 0<=ny && ny < m && arr[nx][ny] ==1){
                    q.add(new Node(nx, ny));
                    arr[nx][ny] += arr[cx][cy];
                }
            }
        }
        return arr[n-1][m-1];
    }
}
class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
