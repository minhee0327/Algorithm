package programmers.level2;

import java.util.*;

//오픈 채팅방
public class Sol46 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution46().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }
}

class Solution46 {
    final String ENTER = "Enter";
    final String LEAVE = "Leave";
    final String Change = "Change";

    Map<String, String> mapID;      //id 관리 map
    List<Opt> list;                 //(enter, userid)담는 queue => 입력받은 순서담기.

    public String[] solution(String[] record) {
        String[] answer;

        mapID = new HashMap<>();
        list = new ArrayList<>();

        for (String r : record) {
            String[] splitRecord = r.split(" ");

            String opt = splitRecord[0];
            String userId = splitRecord[1];
            String userName = splitRecord.length == 3 ? splitRecord[2]: null;

            if (opt.equals(ENTER)) {
                mapID.put(userId, userName);
                list.add(new Opt(opt, userId));
            } else if (opt.equals(Change)) {
                mapID.put(userId, userName);
            } else if (opt.equals(LEAVE)) {
                list.add(new Opt(opt, userId));
            }
        }

        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Opt o = list.get(i);
            if (o.opt.equals(ENTER)) {
                answer[i] = mapID.get(o.userId) + "님이 들어왔습니다.";
            } else if (o.opt.equals(LEAVE)) {
                answer[i] = mapID.get(o.userId) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}

class Opt {
    String opt;
    String userId;

    Opt(String opt, String userId) {
        this.opt = opt;
        this.userId = userId;
    }
}