package thisIsCoding3.greedy;

import java.util.Scanner;

//P. 312 곱하기 혹은 더하기
public class Practice02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s = sc.next().toCharArray();

        int ans = s[0] - '0';

        for(int i = 1; i < s.length; i++){
            int cur = s[i] - '0';
            if(ans <= 1 || cur <= 1){
                ans += cur;
            }else{
                ans *= cur;
            }
        }

        System.out.println(ans);
    }
}
