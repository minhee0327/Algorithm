package aloneBook.bst;

import java.util.Arrays;
import java.util.Scanner;

//p.197
public class Practice01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            //찾는 번호
            int findNum = sc.nextInt();

            boolean flag = bst(arr, findNum, 0, n - 1);

            if(flag){
                sb.append("yes ");
            }else {
                sb.append("no ");
            }
        }

        System.out.println(sb.toString());
    }

    public static boolean bst(int[] arr, int target, int start, int end) {
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return false;
    }
}
