package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Q28_숫자문자열과영단어 {
    public static void main(String[] args) {
        System.out.println(new Solution28().solution("one4seveneight"));
        System.out.println(new Solution28().solution("23four5six7"));
        System.out.println(new Solution28().solution("2three45sixseven"));
        System.out.println(new Solution28().solution("123"));
    }
}

// 나는 당연하게 map 을 떠올렸는데, replaceAll 로 0~10 만큼만 숫자들을 확인하면 좋을걸그랬다..!
class Solution28{
    Map<String, Integer> wordMatching = new HashMap<>();

    public int solution(String s) {
        initMap();
        StringBuilder answer = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for(char c: s.toCharArray()){
            if('0' <= c && c <='9'){
                answer.append(c);
            }else {
                word.append(c);
                if(isNum(word.toString())){
                    answer.append(wordMatching.get(word.toString()));
                    word.setLength(0);
                }
            }
        }

        return Integer.parseInt(answer.toString());
    }

    private boolean isNum(String str) {
        return wordMatching.containsKey(str);
    }

    void initMap(){
        wordMatching.put("zero", 0);
        wordMatching.put("one", 1);
        wordMatching.put("two", 2);
        wordMatching.put("three", 3);
        wordMatching.put("four", 4);
        wordMatching.put("five", 5);
        wordMatching.put("six", 6);
        wordMatching.put("seven", 7);
        wordMatching.put("eight", 8);
        wordMatching.put("nine", 9);
    }
}

class Solution28_1{
    public int solution(String s) {
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i = 0; i < 10; i++){
            s = s.replaceAll(alphabets[i], digits[i]);
        }

        return Integer.parseInt(s);
    }
}