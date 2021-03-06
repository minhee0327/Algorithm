package programmers.greedy;

import java.util.Arrays;

public class 체육복 {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
		System.out.println(solution(5, new int[] {2, 4}, new int[] {3}));
		System.out.println(solution(3, new int[] {3}, new int[] {1}));
	}

	private static int solution(int n, int[] lost, int[] reserve) {
		int ans = 0;

		int[] clothes = new int[n + 1];
		Arrays.fill(clothes, 1);
		
		//잃어버린거 check
		for (int i = 0; i < lost.length; i++) {
			clothes[lost[i]]--;
		}
		//추가옷있는거 check
		for (int i = 0; i < reserve.length; i++) {
			clothes[reserve[i]]++;
		}
		//2가지경우만 고려
		//1. 앞에 애가 안가져왔는데 현재 위치의 애는 여벌 있는경우.
		//2. 앞에 애가 여벌이 있고, 현재 위치의 애는 도난당한 경우.
		for (int i = 1; i < clothes.length; i++) {
			if (clothes[i - 1] == 0 && clothes[i] == 2) {
				clothes[i-1]++; 
				clothes[i]--;
			}else if(clothes[i-1] == 2 && clothes[i] == 0) {
				clothes[i-1] --;
				clothes[i] ++;
			}
		}
		
		for(int i = 1; i < clothes.length; i++) {
			if(clothes[i] >= 1) {
				ans++;
			}
		}

		return ans;
	}

}


/*
 * 
 *[내 사고 흐름]
 * 1. N + 1 크기의 배열을 만든다음 모두 1개씩 체육복을 들고 온것으로 채움. (Arrays.fill(clothes, 1))
 * 2. 도둑맞은 것과, 여벌을 가져온 것을 배열에 값을 적절히 증감 시킴
 * 3. 1번 학생부터 돌면서, 앞에 학생과 비고햠.
 * 	3-1. 만약 나는 여벌(2)이 있고, 앞에애가 안가져왔으면 빌려줌.
 *  3-2. 만약 나는 체육복이 없고(0), 앞에 애가 여벌이 있으면 빌려옴.
 *
 *[다른 사람 풀이 보고 든 생각]
 * - 나는 위 처럼 생각이 나서 구현을 했는데, 다른 풀이중에, 굳이 1로 채우지않고 여벌은 1, 체육복이 없음은 -1로 표기해서 푼점이 좋았다.
 * - 추가로 answer를 구할 때 처음 모든 학생이 수업을 들을수 있었다가, 빌려받지 못한 경우에만 수업을 들을 수 없으므로, answer를 빼가면서
 * 구하는 방법도 인상깊었다. 
 */