package programmers.level2;

//가장 큰 정사각형 찾기
public class Sol15 {
    public static void main(String[] args) {
        System.out.println(new Solution15().solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        System.out.println(new Solution15().solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }
}

class Solution15 {
    public int solution(int[][] board) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        int[][] copy = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                copy[i][j] = board[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (copy[i][j] >= 1) {
                    if (copy[i - 1][j] >= 1 && copy[i][j - 1] >= 1) {
                        copy[i][j] += Math.min(copy[i - 1][j - 1], Math.min(copy[i - 1][j], copy[i][j - 1]));
                    }
                }
                answer = Math.max(copy[i][j], answer);
            }
        }
        return answer * answer;
    }
}