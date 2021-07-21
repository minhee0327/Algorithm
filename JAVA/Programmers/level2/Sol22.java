package programmers.level2;

import java.util.Arrays;

// 삼각 달팽
public class Sol22 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution22().solution(4)));
        System.out.println(Arrays.toString(new Solution22().solution(5)));
        System.out.println(Arrays.toString(new Solution22().solution(6)));
    }
}

class Solution22{
    public int[] solution(int n) {
        int total = n * (n + 1) / 2;
        int[] answer = new int[total];

        int r = 0;
        int c = 0;
        int cnt = 0;
        int[][] map = new int[n][n];

        while (cnt < total) {
            while (r < n && map[r][c] == 0) {
                map[r][c] = ++cnt;
                r++;
                if(r == n || map[r][c]!= 0){
                    r-=1;
                    c+=1;
                    break;
                }
            }

            while (c < n && map[r][c] == 0) {
                map[r][c] = ++cnt;
                c++;
                if(c == n || map[r][c]!= 0){
                    c-=1;
                    break;
                }
            }

            while (r>0 && c>0 && map[--r][--c] == 0) {
                map[r][c] = ++cnt;
            }
            r+=2;
            c+=1;
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[k++] = map[i][j];
            }
        }
        return answer;
    }
}