package programmers.level2;

//방문 길이
public class Sol16 {
    public static void main(String[] args) {
        System.out.println(new Solution16().solution("ULURRDLLU"));
        System.out.println(new Solution16().solution("LULLLLLLU"));
    }
}

class Solution16 {
    // visited check
    boolean[][][][] visited;
    //dx, dy mean: U D R L
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    //(x, y) -> (nx, ny)
    int x = 5, y = 5, nx = 5, ny = 5;
    final static int N = 11;

    public int solution(String dirs) {
        int answer = 0;
        visited = new boolean[N][N][N][N];

        //처음에 String.split("")으로 했는데, toCharArray 로 나눴음
        for (char d : dirs.toCharArray()) {
            //명령에 (U,D,R,L) 맞게 idx 를 가져온다.
            int dir = getDirection(d);
            //한칸 이동시켜본 결과가 조건에 맞는지 체크한다.
            x = nx;
            y = ny;
            nx = dx[dir] + x;
            ny = dy[dir] + y;

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (!visited[x][y][nx][ny]) answer++;
                //양방향 체크를 해야한다.: 방향성까지 체크하는게 아니기 때문에 한번 올라갔던 선분이면 두 방향 모두 체크해주는 것.
                visited[x][y][nx][ny] = true;       // (x, y) -> (nx, ny)
                visited[nx][ny][x][y] = true;       // (nx,ny) -> (x, y)
            } else {
                //이동이 불가능한 경우에는 원래 위치로 복귀한다.
                nx = x;
                ny = y;
            }

        }

        return answer;
    }

    private int getDirection(char d) {
        return switch (d) {
            case 'U' -> 0;
            case 'D' -> 1;
            case 'R' -> 2;
            case 'L' -> 3;
            default -> -1;
        };
    }
}