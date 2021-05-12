package programmers.level2;

import java.util.*;

//파일명 정렬
public class Sol11_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution11_1().solution(new String[]{"i123mg1234567.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(new Solution11_1().solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }
}

class Solution11_1 {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] prevWords = splitWord(o1);
                String[] nxtWords= splitWord(o2);

                int headValue = prevWords[0].compareTo(nxtWords[0]);
                if(headValue == 0){
                    return Integer.compare(Integer.parseInt(prevWords[1]), Integer.parseInt(nxtWords[1]));
                }else{
                    return headValue;
                }
            }
        });
        return files;
    }

    private String[] splitWord(String o1) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        int i = 0;
        for(; i < o1.length(); i++){
            char c = o1.charAt(i);
            if('0' <= c && c <= '9'){
                break;
            }
            head.append(c);
        }
        for(; i < o1.length(); i++){
            char c = o1.charAt(i);
            if(!('0' <= c && c <= '9')){
                break;
            }
            number.append(c);
        }
        for (; i < o1.length(); i++){
            char c = o1.charAt(i);
            tail.append(c);
        }

        return new String[]{head.toString().toUpperCase(), number.toString(), tail.toString()};
    }
}
