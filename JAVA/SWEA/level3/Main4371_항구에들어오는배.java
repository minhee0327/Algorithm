package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4371_항구에들어오는배 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			List<Integer> diff = new ArrayList<Integer>();
			List<Integer> ans = new ArrayList<Integer>();

			for (int i = 0; i < N; i++) {
				diff.add(sc.nextInt() - 1);
			}

			for (int i = 1; i < N; i++) {
				boolean flag = false;
				for (int j = 0; j < ans.size(); j++) {
					if (diff.get(i) % ans.get(j) == 0) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					ans.add(diff.get(i));
				}
			}
			System.out.printf("#%d %d\n", t, ans.size());
		}
		sc.close();
	}
}

/*
 * 엉뚱한데서 시간 많이 잡아먹은 문제;;
 * LinkedList로 풀었더니 계속 시간초과가 났었던 것 같다...
 * LinkedList를 사용했었던 이유가, 처음에 flag를 두지 않고
 * 돌면서 불가능한 경우엔 remove를 원하는 인덱스에서 하려고 썼었던 것인데
 * 중간에 여기에 생각이 꽂히는 바람에 ArrayList로 바꿀 생각을 뒤늦게 했다.. 
 * 
 * ArrayList의 삭제보다 LinkedList의 삭제 수행속도는 조금 더 빠르지만
 * 이 문제의 경우에는 굳이 요소를 삭제 할 필요는 없었던 문제.
 * 특히 탐색 속도로 비교하면 ArrayList가 LinkedList보다 아-----주 많이 차이나게 빠르니까
 * 삭제할 경우가 아니라면 되도록 ArrayList를 사용해야겠다ㅠㅠ
 * 
 * [참조]
 * https://nnoco.tistory.com/73
 **/
