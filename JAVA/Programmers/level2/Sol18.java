package programmers.level2;

import java.util.Arrays;

public class Sol18 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution18().solution(new int[][]{
                {1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}
        })));
        System.out.println(Arrays.toString(new Solution18().solution(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}
        })));

    }
}

class Solution18 {
    int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[]{0, 0};
        int n = arr.length;
        //처음부터 4개 구역으로 나누면 안되고 위에서 전체가 같은 경우도 고려해줘야한다..!
        recursive(arr, 0, n, 0, n);
        return answer;
    }

    private void recursive(int[][] arr, int r1, int r2, int c1, int c2) {
        int pivot = arr[r1][c1];
        boolean flag = true;

        //한 개 칸이 되면 카운트하고 종료
        if (Math.abs(r2 - r1) == 0) {
            if (pivot == 0) answer[0]++;
            else if (pivot == 1) answer[1]++;
            return;
        }

        //그게 아니면 압축가능한지 확인
        outer:
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (pivot != arr[i][j]) {
                    flag = false;
                    break outer;
                }
            }
        }

        //확인해서
        if (flag) {// 압축이 가능한 경우
            if (pivot == 0) answer[0]++;
            else if (pivot == 1) answer[1]++;
        } else { // 압축이 안된 경우
            recursive(arr, r1, (r1 + r2) / 2, c1, (c1 + c2) / 2);
            recursive(arr, (r1 + r2) / 2, r2, c1, (c1 + c2) / 2);
            recursive(arr, r1, (r1 + r2) / 2, (c1 + c2) / 2, c2);
            recursive(arr, (r1 + r2) / 2, r2, (c1 + c2) / 2, c2);
        }
    }
}