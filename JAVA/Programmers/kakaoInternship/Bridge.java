package kakao.internship;

import java.util.LinkedList;
import java.util.Queue;

public class Bridge {
    public static void main(String[] args) {
        System.out.println(new Sol7().solution(new int[][] {{0,0,0},{0,0,0},{0,0,0}}));
    }
}

class Sol7{
    int[] dx = new int[]{1,0,-1,0};
    int[] dy = new int[]{0,-1,0,1};
    int[][] map;
    int N, answer;

    static final int WALL = 1;
    static final int STRAIGHT = 100;       //straight (100)
    static final int CURVE = 600;       //curve (500 + 100)

    public int solution(int[][] board){
        map = board;
        N = board.length;
        answer = Integer.MAX_VALUE;

        //맨 처음 dir 은 실제 direction 과 상관없는 -1을 담아준다.
        bfs(0,0, -1,0);
        return answer;
    }

    public void bfs(int x, int y, int dir, int cost){
        Queue<Car> q = new LinkedList<>();
        q.add(new Car(x, y, dir, cost));
        map[x][y] = 1;                      // 출발지는 더 확인하지 않기 위해 벽으로 세워둔다.

        while(!q.isEmpty()){
            Car car = q.poll();
            int cx = car.x;
            int cy = car.y;
            int cCost = car.cost;
            int cDir = car.dir;

            if(cx == N-1 && cy == N-1){
                answer = Math.min(cCost, answer);
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(0<= nx && nx<N && 0 <= ny && ny<N && map[nx][ny] != WALL){
                    int nextCost = 0;
                    //시작 지점이었거나, 자기자신과 같은 방향인 경우
                    if(cDir == -1 || cDir == i){
                       nextCost = cCost + STRAIGHT;
                    }else {
                        nextCost = cCost + CURVE;
                    }
                    if(map[nx][ny] == 0){
                        map[nx][ny] = nextCost;
                        q.add(new Car(nx, ny, i, nextCost));
                    }else if(map[nx][ny] >= nextCost){
                        map[nx][ny] = nextCost;
                        q.add(new Car(nx, ny, i , nextCost));
                    }
                }
            }

        }
    }

}

class Car{
    int x;
    int y;
    int dir;
    int cost;

    Car(int x, int y, int dir, int cost){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}