package programmers.level3;

public class Sol1_1 {
    public static void main(String[] args) {
        System.out.println(new Solution1_1().solution(4));
    }
}

class Solution1_1 {
    int cnt;
    int[] visited;

    public int solution(int n) {
        visited = new int[n];

        backTrack(0, n);

        return cnt;
    }

    public void backTrack(int row, int n) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isPossible(col, row, n)) {
                visited[row] = col;
                backTrack(row + 1, n);
            }
        }
    }

    public boolean isPossible(int col, int row, int n) {
        for (int i = 0; i < row; i++) {
            if (visited[i] == col || row - i == Math.abs(visited[i] - col)) {
                return false;
            }
        }
        return true;
    }
}
