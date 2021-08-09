package thisIsCoding3.greedy;

import java.util.Arrays;
import java.util.Scanner;

//p.92 sol2. 큰수의법칙
public class Actual01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k  = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int first = arr[n-1];
        int sec = arr[n-2];

        int ans = m / (k+1) * (first * k + sec) + (m % (k+1)) * first;
        System.out.println(ans);
    }

}
