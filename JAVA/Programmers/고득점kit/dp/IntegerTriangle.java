package programmers.dp;

import java.util.Arrays;

public class IntegerTriangle {
    public static void main(String[] args) {
        System.out.println(new Sol2().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}

class Sol2{
    public int solution(int[][] triangle){
        for(int i = triangle.length-1; i > 0; i--){
            for(int j = 1; j < triangle[i].length; j++){
                triangle[i-1][j-1] = triangle[i-1][j-1] + Math.max(triangle[i][j-1], triangle[i][j]);
            }
        }
        return triangle[0][0];
    }
}
