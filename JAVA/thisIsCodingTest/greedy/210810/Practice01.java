package thisIsCoding3.greedy;

import java.util.Arrays;
import java.util.Scanner;

// p. 311 Sol1
public class Practice01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] fear = new int[n];

        for(int i = 0; i < n; i++){
            fear[i] = sc.nextInt();
        }

        Arrays.sort(fear);
        int cnt = 1;
        int guild = 0;

        for(int f: fear){
            if(f <= cnt){
                guild++;
                cnt = 1;
            }else{
                cnt++;
            }
        }

        System.out.println(guild);
    }
}
