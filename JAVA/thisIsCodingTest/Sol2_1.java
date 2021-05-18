package aloneBook.greedy;

import java.util.Scanner;

//p.96 숫자카드게임
public class Sol2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            int temp = Integer.MAX_VALUE;
            for(int j = 0; j < M; j++){
                temp = Math.min(temp, sc.nextInt());
            }
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}
