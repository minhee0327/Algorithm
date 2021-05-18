package aloneBook.implement;

import java.util.Scanner;

//p.115 왕실의 나이트
public class Practice1 {
    static final int[] dx ={2, 2, 1,-1, -2,-2, 1,-1};
    static final int[] dy ={1, -1, -2,-2, 1,-1, 2, 2};
    static final int n = 8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int r = str.charAt(1) - '1';
        int c = str.charAt(0) - 'a';

        int answer = 0;

        for(int i = 0; i < n; i++){
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(0<= nx && nx< n && 0<= ny && ny <n){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
