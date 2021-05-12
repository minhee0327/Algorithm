package programmers.level2;

import java.util.*;

//[3차] 압축
public class Sol13 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution13().solution("KAKAO")));
        System.out.println(Arrays.toString(new Solution13().solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(new Solution13().solution("ABABABABABABABAB")));
    }
}

class Solution13{
    Map<String, Integer> dict;
    int dictSize, wordLen, start, end;
    public int[] solution(String mst){
        dict = new HashMap<>();
        dictSize = 26;
        start = 0;
        end = start+1;

        //1. ++i 사용에 주의하자. 반복문 도는데, put 쓸때 ++i 하는 바람에 단어를 건너서 저장해버렸다 (A,C,E,..) 이런식으로(왜 안되는지 한참 찾은거..)
        for(int i = 0; i < dictSize; i++){
            dict.put(String.valueOf((char)('A'+i)), i+1);
        }

        List<Integer> candidate = new ArrayList<>();

        while(start < mst.length()){
            wordLen = 1;
            //2. mst.length()를 포함해서 검사하는 이유: subString의 두번째 인자 전까지 자르니까.
            while(start+wordLen <= mst.length() && dict.containsKey(mst.substring(start, start+wordLen))){
                wordLen++;
            }

            end = start+wordLen-1;

            //4. end 가 mst.length()보다 크거나 같다는건 마지막 남은 문자만 처리해주면 된다는 의미.
            if(end>= mst.length()){
                candidate.add(dict.get(mst.substring(start)));
                break;
            }

            String w = mst.substring(start, end);
            String c = String.valueOf(mst.charAt(end));

            candidate.add(dict.get(w));
            dict.put(w+c, ++dictSize);

            // 6. 단어의 길이가 2보다 큰 경우엔 start 지점을 (word-1) 만큼 이동해줘야한다.
            // word -2 를 한 이유는 다음에 start 를 한번 더 증가 시킬 것이기 때문.
            if(wordLen> 1) start += wordLen-2;
            start++;

        }

        int[] answer = new int[candidate.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = candidate.get(i);
        }
        return answer;
    }

}