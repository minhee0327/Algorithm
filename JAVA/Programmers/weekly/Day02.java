package programmers.monthly;

import java.util.Arrays;

public class Day02 {
    public static void main(String[] args) {
        System.out.println(new Solution02().solution(new int[][]{{50, 90}, {50, 87}}));
    }
}

class Solution02 {
    int N;
    int[][] arr;

    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        N = scores.length;
        rotate(scores);

        for (int i = 0; i < N; i++) {
            int sum = Arrays.stream(arr[i]).sum();
            int avg = 0;
            int myScore = arr[i][N-1-i];
            Arrays.sort(arr[i]);

            if (uniqueMax(i, myScore) || uniqueMin(i, myScore)) {
                sum -= myScore;
                avg = sum / (N - 1);
            } else {
                avg = sum / N;
            }
            answer.append(findScore(avg));
        }
        return String.valueOf(answer);
    }

    private String findScore(int avg) {
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    private boolean uniqueMax(int i, int score) {
        return arr[i][N - 1] != arr[i][N - 2] && arr[i][N - 1] == score;
    }

    private boolean uniqueMin(int i, int score) {
        return arr[i][0] != arr[i][1] && arr[i][0] == score;
    }

    private void rotate(int[][] scores) {
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[j][N - 1 - i] = scores[i][j];
            }
        }
    }
}