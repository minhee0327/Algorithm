package level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main4047_영준이의카드카운팅 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String S = sc.next();
			List<String> card = new ArrayList<String>();
			int count[] = { 13, 13, 13, 13 };
			// 카드 정보 쪼개어 담기
			for (int i = 0; i < S.length() / 3; i++) {
				card.add(S.substring(3 * i, 3 * (i + 1)));
			}

			// 중복되는 카드가 있는지 확인하기 위해 set으로 변환
			Set<String> hashCard = new HashSet<String>(card);

			// 길이가 다르면, 중복되는게 있었다는 뜻이니 ERROR출력 후 종료시키고
			// 길이가 같으면 중복되는게 없으니, 해당하는 모양에 대한 index를 찾아서 count배열을 빼준다. 그리고 출력
			if (card.size() != hashCard.size()) {
				System.out.printf("#%d %s\n", t, "ERROR");
				continue;
			} else {
				for (int i = 0; i < S.length() / 3; i++) {
					int idx = changeIdx(card.get(i).charAt(0));
					count[idx]--;
				}
				System.out.printf("#%d ", t);
				for (int i = 0; i < 4; i++) {
					System.out.printf("%d ", count[i]);
				}
				System.out.println();
			}
		}

		sc.close();
	}

	// 만약에 S,D,H,C이외의 문자열이 들어왔다면 여기서는 예외처리 않고, 의도적으로 엄청 작은 수를 넣어서 처리해보았다.
	private static int changeIdx(char c) {
		if (c == 'S') {
			return 0;
		} else if (c == 'D') {
			return 1;
		} else if (c == 'H') {
			return 2;
		} else if (c == 'C') {
			return 3;
		} else {
			return Integer.MIN_VALUE;
		}
	}
}
