package programmers.level1;

public class Q29_신규아이디추천 {
    public static void main(String[] args) {
        System.out.println(new Solution29().solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(new Solution29().solution("z-+.^."));
        System.out.println(new Solution29().solution("=.="));
        System.out.println(new Solution29().solution("123_.def"));
        System.out.println(new Solution29().solution("abcdefghijklmn.p"));
    }
}
class Solution29{
    public String solution(String new_id) {

        new_id = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(char c: new_id.toCharArray()){
            if('0' <= c && c <= '9' || 'a' <= c && c <= 'z' || "-_.".contains(String.valueOf(c))){
               sb.append(c);
            }
        }
        new_id = sb.toString();

        while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }
        if(new_id.charAt(0)=='.') new_id = new_id.substring(1);
        if(new_id.length()>0 && new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);


        if(new_id.isEmpty()) new_id = "a";

        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }

        StringBuilder new_idBuilder = new StringBuilder(new_id);
        while(new_idBuilder.length()<=2){
            new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length() - 1));
        }
        new_id = new_idBuilder.toString();

        return new_id;
    }
}

//best practice (regExp 를 이렇게 잘 쓰고 싶다..)
class Solution29_1{
    public String solution(String new_id) {
        String answer = "";

        //1. 소문자
        String temp = new_id.toLowerCase();
        //2.숫자, 문자, -_. 은 제외 ("")
        temp = temp.replaceAll("[^-_.a-z0-9]","");
        //3. .. -> .
        temp = temp.replaceAll("[.]{2,}",".");
        //4. .로 시작하거나 .로끝나는거는 제외
        temp = temp.replaceAll("^[.]|[.]$","");
        //5. 공백은 "a"
        if(temp.equals(""))
            temp+="a";
        //6. 길이 16 이상은 15까지 자르고, 앞뒤로 있는 . 는 제거
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        //7. 길이가 2 이하인 경우, 3이 될때까지 마지막 문자를 연결한다.
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
}