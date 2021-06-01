package aloneBook.graph;

import java.util.*;

// p.303 커리큘럼
public class Practice3 {
    static int N;
    static int[] inDegree, time;
    static List<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        inDegree = new int[N+1];
        time = new int[N+1];
        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++){
            time[i] = sc.nextInt();

            while(true){
                int prevStudy = sc.nextInt();
                if(prevStudy == -1) break;
                inDegree[i]++;

                graph.get(prevStudy).add(i);
            }
        }

        topologySort();
    }

    private static void topologySort(){
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[time.length];
        System.arraycopy(time, 0, result, 0, time.length);

        for(int i = 1; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int nxt: graph.get(now)){
                inDegree[nxt]--;
                result[nxt] = Math.max(result[nxt], result[now]+ time[nxt]);
                if(inDegree[nxt] == 0){
                    q.add(nxt);
                }
            }
        }

       for(int i = 1; i < result.length; i++){
           System.out.println(result[i]);
       }

    }
}

/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */