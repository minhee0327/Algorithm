package programmers.dp;

import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class Nrepresentation {
    public static void main(String[] args) {
        System.out.println(new Sol1().solution(5, 12));
        System.out.println(new Sol1().solution(2, 11));
    }
}

//? 통과는 되는데.. 배열을 collections type 으로 선언하면 안되는지는 별도로 알아봐야될 듯;(IDE 에서 경고 뜸)
class Sol1{
    int N, number;
    TreeSet[] dp;

    public int solution(int N, int number){
        this.N= N;
        this.number = number;
        dp = new TreeSet[10];

        for(int i = 1; i <= 8; i++){
            makeNum(i);
            if(dp[i].contains(number)){
                return i;
            }
        }
        return -1;
    }

    private TreeSet<Integer> makeNum(int len){
        if(dp[len] != null && !dp[len].isEmpty()){
            return dp[len];
        }

        int tempN = 0;
        for(int i = 0; i < len; i ++){
            tempN = tempN * 10 + N;
        }

        TreeSet <Integer> candidate = new TreeSet<>();
        candidate.add(tempN);

        for(int i = 1 ; i < len; i++){
            int j = len - i;
            TreeSet <Integer> prev = makeNum(i);
            TreeSet <Integer> nxt = makeNum(j);

            for(Integer p: prev){
                for(Integer n: nxt){
                    candidate.add(p + n);
                    candidate.add(p - n);
                    candidate.add(p * n);
                    if(n!= 0) candidate.add(p / n);
                }
            }
        }
        return dp[len] = candidate;
    }

    //backup
//    private void makeNumList(int len) {
//        if(!candidate.isEmpty()){
//            prevSet.addAll(candidate);
//        }
//
//        candidate = new TreeSet<>();
//        //len 길이에 맞는 수
//        int curN = N;
//        for(int i = 1; i < len; i++){
//            curN = curN * 10 + N;
//        }
//
//        if(!prevSet.isEmpty()){
//            for(Integer i: prevSet){
//                candidate.add(i + N);
//                candidate.add(i - N);
//                candidate.add(i * N);
//                candidate.add(i * N  * -1);
//                if(N!=0) candidate.add(i / N);
//                if(N!=0) candidate.add(i * -1 / N);
//            }
//        }
//        candidate.add(curN);
//    }
}