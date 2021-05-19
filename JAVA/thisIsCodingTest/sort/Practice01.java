package aloneBook.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//p178 위에서 아래로
public class Practice01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        //I/O 시간 단축위해 StringBuilder 로 문자열 만들어서 한번에 출력함;
        StringBuilder sb = new StringBuilder();
        for(int i: arr){
            sb.append(String.valueOf(i)).append(" ");
        }

        System.out.println(sb.toString());
    }

}
