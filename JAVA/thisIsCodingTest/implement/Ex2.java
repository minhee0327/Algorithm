package aloneBook.implement;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 60; j++){
                for(int k = 0; k < 60; k++){
                    String time = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    if(time.contains("3")){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
