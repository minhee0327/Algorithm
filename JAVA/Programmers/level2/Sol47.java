package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class Sol47 {
    public static void main(String[] args) {
        System.out.println(new Solution47().solution(2, new String[] {"N~F=0", "R~T>2"}));
        System.out.println(new Solution47().solution(2, new String[] {"M~C<2", "C~M>1"}));
    }
}

class Solution47{
    final int N = 8;
    int answer;

    int[] pos;
    boolean[] visited;
    Map<Character, Integer> map;

    public int solution(int n, String[] data) {
        visited = new boolean[N];
        pos = new int[N];
        initMap();
        permutation(0, data);

        return answer;
    }

    private void initMap() {
        map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);
    }

    public void permutation(int depth, String[] data){
        if(depth == 8){
            if(isOk(data)){
                answer++;
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                pos[depth] = i;
                permutation(depth+1, data);
                visited[i] = false;
            }
        }

    }

    private boolean isOk(String[] data) {
        for (String condition : data) {
            int a = map.get(condition.charAt(0));       //앞에 애
            int b = map.get(condition.charAt(2));       //상대방 애
            char opt = condition.charAt(3);
            int num = condition.charAt(4) - '0';
            int diff = Math.abs(pos[a] - pos[b]) - 1;

            if (opt == '=') {
                if (diff != num) {
                    return false;
                }
            } else if (opt == '>') {
                if (diff <= num) {
                    return false;
                }
            } else if (opt == '<') {
                if (diff >= num) {
                    return false;
                }
            }

        }
        return true;
    }
}