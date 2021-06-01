package aloneBook.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//p.300 도시분할계획
public class Practice2 {
    static int N, M;
    static List<P2Edges> edges;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        edges = new ArrayList<>();
        parent = new int[N+1];
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        for(int i  = 0; i < M ; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            edges.add(new P2Edges(A,B,C));
        }

        Collections.sort(edges);

        int result = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < edges.size(); i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();

            if(find(a) != find(b)){
                result += cost;
                union(a,b);
                if(max < cost){
                    max = cost;
                }
            }
        }

        result -= max;

        System.out.println(result);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a> b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }

    public static int find(int v){
        if(v != parent[v]) parent[v] = find(parent[v]);
        return parent[v];
    }
}

class P2Edges implements Comparable<P2Edges>{
    int a;
    int b;
    int cost;

    P2Edges(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(P2Edges o) {
        return this.cost - o.cost;
    }
}

/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
*/
