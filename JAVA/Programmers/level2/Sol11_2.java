package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//파일명 정렬
public class Sol11_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution11().solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(new Solution11().solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }
}

class Solution11_2 {
    public String[] solution(String[] files) {
        int n = files.length;
        List<Word2> list = new ArrayList<>();

        for(String f: files){
            list.add(new Word2(splitWord(f)));
        }

        Collections.sort(list);

        for(int i = 0; i < n; i++){
            files[i] = list.get(i).toString();
        }

        return files;
    }

    private static String[] splitWord(String o1) {
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

        return new String[]{head.toString(), number.toString(), tail.toString()};
    }
}

class Word2 implements Comparable<Word2> {
    String head;
    String number;
    String tail;

    Word2(String[] splitWord) {
        this.head = splitWord[0];
        this.number = splitWord[1];
        this.tail = splitWord[2];
    }

    @Override
    public int compareTo(Word2 o) {
        if (!this.head.equalsIgnoreCase(o.head)) {
            return this.head.toUpperCase().compareTo(o.head.toUpperCase());
        } else {
            return Integer.parseInt(this.number) - Integer.parseInt(o.number);
        }
    }

    @Override
    public String toString() {
        return this.head +this.number+this.tail;
    }
}