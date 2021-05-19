package aloneBook.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//p.182 두배열의 원소교체
public class Practice03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];

        for(int i = 0; i < n; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            arr2[i] = sc.nextInt();
        }

        //arr1 asc, arr2 desc
        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());


        for(int i = 0; i < n && k>0; i++){
            if(arr1[i] <arr2[i]){
                //swap
                int temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp;
                k--;
            }
        }

        int answer = 0;
        for(int i: arr1){
            answer+=i;
        }
        System.out.println(answer);
    }
}
