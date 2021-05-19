package aloneBook.bst;

import java.util.Arrays;
import java.util.Scanner;

//p.201 떡볶이떡 만들기
public class Practice02 {
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int start = arr[0];
        int end = arr[n-1];
        answer = Integer.MIN_VALUE;

        bst(arr, m, start, end);

        System.out.println(answer);
    }

    public static void bst(int[] arr, int target, int start, int end){
        while(start<= end){
            int mid = (start+end)/2;

            int sum = 0;
            for(int i = 0; i < arr.length;i++){
                if(arr[i]> mid){
                    sum += arr[i]-mid;
                }
            }

            if(sum >= target){
                answer = Math.max(answer, mid);
                start = mid +1;
            }else{
                end = mid-1;
            }
        }
    }
}
