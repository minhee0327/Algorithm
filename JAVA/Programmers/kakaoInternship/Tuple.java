package kakao.internship;

import java.util.*;

//튜플
public class Tuple {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Sol4().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(new Sol4().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(new Sol4().solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(new Sol4().solution("{{123}}")));
        System.out.println(Arrays.toString(new Sol4().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}

class Sol4{
    public int[] solution(String s) {
        String str = s.substring(2, s.length()-2).replace("},{", "-");

        String[] arr = str.split("-");

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            String[] temp = arr[i].split(",");

            for(String t: temp){
                int num = Integer.parseInt(t);
                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
