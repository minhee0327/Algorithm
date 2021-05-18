package aloneBook.greedy;

import java.util.*;

//p.96 숫자카드게임
public class Sol2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> rows = new ArrayList<>();
        for(int i = 0; i < N; i++){
            List<Integer> columns = new ArrayList<>();
            for(int j = 0; j < M; j++){
                columns.add(sc.nextInt());
            }
            Collections.sort(columns);
            rows.add(columns.get(0));
        }
        Collections.sort(rows);

        System.out.println(rows.get(rows.size()-1));
    }
}
