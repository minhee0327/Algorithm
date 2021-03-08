package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
	// python dict가 생각나서, hashMap으로 구현을 해보면 좋겠다고 생각했다.
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
		System.out.println(solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
		System.out.println(solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
	}

	public static String solution(String[] participant, String[] completion) {
		Map <String, Integer> hm = new HashMap<>();
		
		// 참가자가 아직 hm에 등록이 안되어있으면 1로 초기화해주고, 등록되어있으면 기존value에 +1 해준다.
		for(int i = 0; i < participant.length; i++) {
			if (hm.containsKey(participant[i])) {
				hm.put(participant[i], hm.get(participant[i])+1); 
			}else {
				hm.put(participant[i], 1);
			}
		}
		
		// completion 을 돌면서 참가자 이름에 해당하는 value 빼주기
		for (int i = 0; i < completion.length; i++) {
			if(hm.containsKey(completion[i])) {
				hm.put(completion[i], hm.get(completion[i])-1); 
			}
		}
		
		String answer = "";
		for(String key: hm.keySet()) {
			if(hm.get(key) >= 1) {
				answer = key;
			}
		}
		
		return answer;
	}
}
