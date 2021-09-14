package boj.bfs;

import java.util.Scanner;

public class Main1058_1 {
    static int[][] arr;
    final static int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            char[] YN = sc.next().toCharArray();
            for(int j = 0; j < YN.length; j++){
                if(YN[j]=='Y'){
                    arr[i][j] = 1;
                }else if(YN[j] == 'N'){
                    //mistake: N 일때 0으로 잘 못 초기화 했었음
                    arr[i][j] = INF;
                }
            }
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        int maxCnt = 0;
        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < N; j++){
                //mistake2: 자기자신인 경우를 고려하지 않았음
                if(i == j) continue;
                if(0 < arr[i][j] && arr[i][j] <= 2){
                    cnt++;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }


        System.out.println(maxCnt);
    }
}
