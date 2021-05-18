package aloneBook.greedy;
import java.util.Scanner;

//p.99 1이 될때까지
public class Sol3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int answer = 0;

        while(N!=1){
            if(N%K==0){
                N/=K;
            }else{
                N-=1;
            }
            answer++;
        }

        System.out.println(answer);
    }
}