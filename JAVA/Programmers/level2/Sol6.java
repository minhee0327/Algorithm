package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sol6 {
    public static void main(String[] args) {
        System.out.println(new Solution6().solution("1 2 3 4"));
        System.out.println(new Solution6().solution("-1 -2 -3 -4"));
        System.out.println(new Solution6().solution("-1 -1"));
        System.out.println(new Solution6().solution("-1 0 -1"));
        System.out.println(new Solution6().solution("-1 -1 2 3 0 -2"));
    }
}

class Solution6{
    public String solution(String s) {
        String answer = "";

        String temp[] = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for(String t: temp){
            if(t.charAt(0) =='-'){
                list.add((Integer.parseInt(t.substring(1)) * -1));
            }else{
                list.add(Integer.parseInt(t));
            }
        }
        Collections.sort(list);
        answer = list.get(0) + " " + list.get(list.size()-1);
        return answer;
    }

    //아.. 음수 parseInt 하면 바로 음수로 넣어준다;; 흐어...
    public String solution2(String s){
        String answer = "";
        List <Integer>list = new ArrayList<>();
        for(String t: s.split(" ")){
            list.add(Integer.parseInt(t));
        }
        Collections.sort(list);
        return list.get(0) +" " +list.get(list.size()-1);
    }
}