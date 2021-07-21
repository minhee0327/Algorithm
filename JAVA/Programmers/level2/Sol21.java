package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

//[1차] 캐시
public class Sol21 {
    public static void main(String[] args) {
        System.out.println(new Solution21().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(new Solution21().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(new Solution21().solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(new Solution21().solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(new Solution21().solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(new Solution21().solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));

    }
}

class Solution21 {
    public final int HIT = 1;
    public final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();

        if(cacheSize == 0) return cities.length * MISS;

        for (String c : cities) {
            c = c.toLowerCase();
            //적중
            if(q.remove(c)){
                answer += HIT;
                q.add(c);
            }else {
                if(q.size() == cacheSize) q.poll();
                q.add(c);
                answer+= MISS;
            }
        }

        return answer;
    }
}