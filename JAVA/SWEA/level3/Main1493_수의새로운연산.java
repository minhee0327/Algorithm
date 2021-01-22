
package level3;

import java.util.Scanner;

public class Main1493_수의새로운연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			int pArr[] = findXY(p);
			int qArr[] = findXY(q);
			
			int x = pArr[0] + qArr[0];
			int y = pArr[1] + qArr[1];
			
			System.out.printf("#%d %d\n", t, findVal(x, y));
			
		}
	}

	//해당 좌표에 대한 값을 찾는 함수
	private static int findVal(int x, int y) {
		int sum = 1; 
		for(int i = 1; i < x+y-1; i++) {
			sum += i;
		}
		sum +=  (x - 1);
		return sum;
	}

	//x, y 좌표값을 참는 함수
	public static int[] findXY(int n) {
		int[] result = new int[2];
		int sum = 0;
		
		for(int i = 0; ; i++) {
			sum += i;
			if(sum >= n) {
				result[0] = i - (sum - n);
				result[1] = i + 1 - result[0];
				return result;
			}
		}
	}


}

/*
- 내가 생각했던 첫 방안은
- 먼저 대각선으로 값을 채운뒤에, 해당하는 값을 가진 p, q에 대한 좌표를 찾는 것이었다.
- 각 좌표의 x, y끼리의 합에 해당하는 배열을 찾아서 return 하고싶었으나,
- 주어진 문제에서 p, q에 대해 10001이라는 정보만 있기 때문에 어디까지 채워야 합당한지 생각할 수 없었다.
- (댓글에 300으로 하면 풀린대서, 그렇게 하면 될거라는 생각은 들었음) 


그래서 참조
- https://zzang9ha.tistory.com/262
- 이 블로그에서 나온 방법은 처음 접근하는 방법이었다.
- 결론적으로, 대각선 차수별, 맨 우측 아래 값을 기준으로 p보다 크다면 해당 차수를 구할수가 있고
- 그 때 각 좌표를 구하면 됨. (좌표 구한 계산이 신기했음)
- x: 대각선 차수 - (우측 맨 아래 기준 값 - 현재 값)
- y: 대각선 차수 + 1 - x

- 이런 사고를 할 수 있다는 것이 놀랍다..!! 아직 멀었구나 ㅠㅠ


- 참조 2는
- https://zetawiki.com/wiki/SWEA_1493_%EC%88%98%EC%9D%98_%EC%83%88%EB%A1%9C%EC%9A%B4_%EC%97%B0%EC%82%B0
- 이사람이 짠 코드에서 너무 좋았던 것은
- 필요한 기능별로 함수를 잘게 쪼개놔서 어떤 역할을 하는 애들인지 알 수 있어서 좋았다.
- 다만sharp(int x, int y) 함수 내부에서
- 계산식이 어떻게 나온 것인지 궁금했는데.. 해설이 없어서.. 현재 내 머리로는 이해하기가 조금 어려웠다....ㅠㅠ
- 나중에 다시 보면 이해 할 수 있으려나... 

*/
