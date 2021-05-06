package kakao.internship;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//불량 사용자
public class BlackUser {
    public static void main(String[] args) {
        System.out.println(new Sol5().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "abc1**"}));
    }
}

class Sol5 {
    Set<String> set;
    String[] userId;       //user_id
    String[] bannedId;     //banned_id
    boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        set = new HashSet<>();
        userId = user_id;
        visited = new boolean[userId.length];
        bannedId = new String[banned_id.length];

        for (int i = 0; i < banned_id.length; i++) {
            bannedId[i] = banned_id[i].replace("*", ".");
        }

        backTrack(0, "");

        return set.size();
    }

    private void backTrack(int idx, String result) {
        //탐색을하다가 idx 가 banedIdx 의 길이와 일치하면 set 에 결과를 담아준다.
        //단, 담을 때 기준은 이름을 정렬해서 만든 문자열을 기준으로 잡난다.
        if (idx == bannedId.length) {
            String[] temp = result.split(" ");
            Arrays.sort(temp);
            StringBuilder sb = new StringBuilder();
            for(String t: temp){
                sb.append(t);
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < userId.length; i++) {
            // userId 중 방문하지 않았고, userId와 bannedId 가 일치하면 탐색해본다.
            if (!visited[i] && userId[i].matches(bannedId[idx])) {
                visited[i] = true;
                backTrack(idx + 1, result+ " "+ userId[i]);
                visited[i] = false;
            }
        }
    }
}

/*
* 1. 정규표현식에서 . 가 의미하는 것:  any character except /n
*/
