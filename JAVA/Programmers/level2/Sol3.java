package programmers.level2;

import java.util.Arrays;
//행렬의 곱셈
public class Sol3 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution3().solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}})));
    }
}

class Solution3{
    public int[][] solution(int[][] arr1, int[][] arr2){
        int[][] temp = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int k = 0; k < arr2[0].length; k++){
                for(int j = 0; j < arr1[0].length; j++){
                    temp[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        return temp;
    }
}
