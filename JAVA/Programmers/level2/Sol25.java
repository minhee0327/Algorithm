package programmers.level2;

//[1차] 프렌즈 4 블록
public class Sol25 {
    public static void main(String[] args) {
        System.out.println(new Solution25().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println();
        System.out.println(new Solution25().solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }
}

class Solution25 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int cnt = checkBlock(map, m, n);
            if (cnt == 0) break;
            answer+= cnt;
            dropBlock(m, n, map);
        }

        return answer;
    }

    public void dropBlock(int m, int n, char[][] map) {
        //블록들을 내린다. 확인시 행의 아래에서부터 위로 검토한다.
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public int checkBlock(char[][] map, int m, int n) {
        int ret = 0;
        boolean[][] visited = new boolean[m][n];

        //1. 빈칸이 아닌 경우엔 네개의 위치를 확인해본다.
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] != '.') {
                    checkFour(map, visited, i, j);
                }
            }
        }

        //3. 지워야하는 블록의 개수를 세어주고, 지워야하는 위치는 일단 '.' 으로 빈 표시를 해준다.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    ret++;
                    map[i][j] = '.';
                }
            }
        }

        return ret;
    }

    public void checkFour(char[][] map, boolean[][] visited, int cx, int cy) {
        //2-1. 오른, 아래, 오른아래대각선과 동일하지 않으면 종료
        for (int i = cx; i <= cx + 1; i++) {
            for (int j = cy; j <= cy + 1; j++) {
                if (map[i][j] != map[cx][cy]) {
                    return;
                }
            }
        }
        //2-2. 4개 블록이 일치해 제거해야서하면 위치를 표 해준다.
        for (int i = cx; i <= cx + 1; i++) {
            for (int j = cy; j <= cy + 1; j++) {
                visited[i][j] = true;
            }
        }

    }
}

//https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%94%84%EB%A0%8C%EC%A6%884%EB%B8%94%EB%A1%9D-Java 참조