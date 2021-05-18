package aloneBook.implement;

import java.util.Scanner;

public class Ex1 {
    public final static int[] dx = {1,0,-1,0}; // D ,L, U, R
    public final static int[] dy = {0,-1,0,1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] opt = sc.nextLine().split(" ");


        int cx = 1;
        int cy = 1;

        for(String o: opt){
            int idx = convertIdx(o);
            int nx = cx + dx[idx];
            int ny = cy + dy[idx];

            if(0<nx && nx<=n && 0<ny && ny<= n){
                cx = nx;
                cy = ny;
            }
        }
        System.out.println(cx + " " + cy);
    }

    private static int convertIdx(String o) {
        if(o.equals("D")){
            return 0;
        }else if(o.equals("L")){
            return 1;
        }else if (o.equals("U")){
            return 2;
        }else if (o.equals("R")){
            return 3;
        }else {
            return -1;
        }
    }
}
