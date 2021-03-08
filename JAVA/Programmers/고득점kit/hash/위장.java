package programmers.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class 위장 {

	public static void main(String[] args) {
		System.out.println(solution(new String[][] { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } }));
		System.out.println(solution(
				new String[][] { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } }));
	}

	private static int solution(String[][] clothes) {
		int answer = 1;
		
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			if (map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			} else {
				map.put(clothes[i][1], 1);
			}
		}
		
		for(Entry<String, Integer> e: map.entrySet()) {
			answer *= (e.getValue() + 1);
		}
		
		return answer -1;
	}
	
	private static int solution2(String[][] clothes) {
		int answer = 1;
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		
		for(Entry<String, Integer> e: map.entrySet()) {
			answer *= (e.getValue() + 1);
		}
		
		return answer -1;
	}

}

/*
 * https://2ssue.github.io/algorithm/programmers_42578/
 * 
 * 위 포스팅대로, 나는 확률과 통계 파트를 어떻게 계산해야 좋을지 idea 가 없었다. 4종류의 옷이 있고, 그 종류의 옷이 {a, b,
 * c, d}의 개수로 있을 때 각 종류들은 하나를 입거나, 안입거나의 선택지가 있으므로 옷의 갯수에 안입는 선택지를 하나 추가한다. 그리고
 * 옷을 고르는 선택은 동시에 일어나니까 * 로 경우의 수를 구한후 하나도 안 입는 선택지는 없으므로 1을 빼준다.
 * 
 * 확률과 통계를 별도로 다시 리뷰애햐하나..ㅠㅠ 확률 통계 앞에 너무 작아진다;
 */