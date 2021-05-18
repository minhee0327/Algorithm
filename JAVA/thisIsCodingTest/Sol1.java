package aloneBook.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//p92. 믄 수의 법칙
public class Sol1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        Integer [] arr = new Integer[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int idx = 0,cnt = 0, answer = 0;
        while(M>0){
            if(cnt<K){
                answer+= arr[idx];
                cnt++;
            }else{
                answer+= arr[idx+1];
                cnt = 0;
            }
            M--;
        }

        System.out.println(answer);
    }
}
