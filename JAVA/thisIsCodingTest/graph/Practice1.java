package aloneBook.graph;

import java.util.Scanner;

// 팀결성 p.298
public class Practice1 {
    static int[] parent;
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        parent = new int[N+1];

        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int opt = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(opt == 0){
                union(a, b);
            }else{
                if(find(a) == find(b)){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a > b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }

    private static int find(int v) {
        if(v != parent[v]) parent[v] = find(parent[v]);
        return parent[v];
    }
}
