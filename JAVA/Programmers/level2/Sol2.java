package programmers.level2;

//JadenCase 문자열 만들기
public class Sol2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().solution2("3people unFollowed me"));
        System.out.println(new Solution2().solution2("for the last week"));
        System.out.println(new Solution2().solution2(" for the last week test "));
    }
}

class Solution2{
    public String solution(String s) {
        String[] splitStr = s.split(" ");
        StringBuilder tempAns = new StringBuilder();

        for(int i = 0; i < splitStr.length; i++){
            String word = splitStr[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < word.length(); j++){
                if(j == 0){
                   sb.append(String.valueOf(word.charAt(j)).toUpperCase());
                }else{
                   sb.append(String.valueOf(word.charAt(j)).toLowerCase());
                }
            }
            tempAns.append(sb.toString()).append(" ");
        }
        if (s.charAt(0) == ' ' || s.charAt(s.length()-1) ==' '){
            return tempAns.toString();
        }
        return tempAns.toString().trim();
    }

    //programmers 답 풀이
    public String solution2(String s){
        StringBuilder answer = new StringBuilder();
        //1. 모두 소문자로 바꿔서 split 해준다.
        String[] temp = s.toLowerCase().split("");
        //2.flag는 맨 처음 아니면 공백 바로 뒤에 true 이고, flag 가 true 일 때에만 upperCase로.
        boolean flag = true;

        for(String t: temp){
            answer.append(flag ? t.toUpperCase() : t);
            flag = t.equals(" ");
        }

        return answer.toString();
    }
}