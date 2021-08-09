package thisIsCoding3.greedy;

import java.util.Scanner;

public class Actual02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int max = Integer.MIN_VALUE;
        for(int i = 0; i< n; i ++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                int input = sc.nextInt();
                if(min > input){
                    min = input;
                }
            }
            max = Math.max(max, min);
        }

        System.out.println(max);
    }
}
