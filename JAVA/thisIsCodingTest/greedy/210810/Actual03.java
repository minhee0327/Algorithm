package thisIsCoding3.greedy;

import java.util.Scanner;

//p.99 1이 될 때까지
public class Actual03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;

        while(n != 1){
            if(n % k == 0){
                n/= k;
            }else{
                n-=1;
            }
            ans ++;
        }

        System.out.println(ans);
    }
}
