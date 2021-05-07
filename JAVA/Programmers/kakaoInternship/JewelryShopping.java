package kakao.internship;

import java.util.*;

// 처음 그냥 2중반복문을 풀려고 했을 때 이미 초과가 날 것 같았으나, 별다른 알고리즘이 생각나지 않았다.
// 일단 구현하고 돌렸더니 역시나 시간 초과.. 그래서 참조했다.
// 처음 보는 two pointer algorithm 을 접해서 이해하는데도 한참 걸렸다...
public class JewelryShopping {
    //TestCase
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Sol6().solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println(Arrays.toString(new Sol6().solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
        System.out.println(Arrays.toString(new Sol6().solution(new String[]{"XYZ", "XYZ", "XYZ"})));
        System.out.println(Arrays.toString(new Sol6().solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
    }
}

class Sol6{
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        int start = 0, end = Integer.MAX_VALUE;
        int finStart = 0;

        for(String g: gems){
            map.put(g, map.getOrDefault(g, 0) + 1);
            q.add(g);

            while(true){
                String temp = q.peek();
                if(map.get(temp) > 1){
                    start++;
                    q.poll();
                    map.put(temp, map.get(temp) -1);
                }else{
                    break;
                }
            }

            if(map.size() == set.size() && end > q.size()){
                end = q.size();
                finStart = start;
            }
        }

        return new int[]{finStart+1, finStart + end};
    }
}

/*
* 1. two-pointer algorithm, sliding window
* 2. 참조자료
* - https://m.blog.naver.com/kks227/220795165570
* - https://tosuccess.tistory.com/133
* */