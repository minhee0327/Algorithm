package level3;

import java.util.Scanner;

public class Main5293_이진문자열복원 {
	public static int[] ABCD = new int[4];
	public static int strLen;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			for(int i = 0; i < ABCD.length; i++) {
				ABCD[i] = sc.nextInt();
				strLen += ABCD[i];
			}

			String ans = "";
			boolean flag = false;
			
			for(int i = 0; i < Math.pow(2, strLen + 1);i++) {
				String temp = Integer.toBinaryString(i);
				if(temp.length()<=1) {
					temp = "0" + temp;
				}
				if(isFindStr(temp)) {
					ans = temp; 
					flag = true;
					break;
				}
			}
			
			if(flag) {
				System.out.printf("#%d %s\n", t, ans);
			}else {
				System.out.printf("#%d %s\n", t, "impossible");
			}
			
		}
		
	}
	//복구 가능한 문자열인지 체크
	private static boolean isFindStr(String str) {
		int[] arr = new int[4];
		System.arraycopy(ABCD, 0, arr, 0, arr.length);
		
		for(int i = 0; i < str.length() - 1; i++) {
			int idx = findIdx(str.substring(i, i+2));
			if (idx<0 || arr[idx]<0) {
				return false;
			}else {
				arr[idx]--;
			}
		}
		for(int i = 0; i < 4; i++) {
			if(arr[i]!= 0) {
				return false;
			}
		}
		return true;
	}
	//00, 01, 10, 11의 idx를 찾아주기
	private static int findIdx(String s) {
		if(s.equals("00")) {
			return 0;
		}else if(s.equals("01")){
			return 1;
		}else if (s.equals("10")) {
			return 2;
		}else if (s.equals("11")) {
			return 3;
		}
		return -1;
	}

}

/*처음 생각했던 방식 => 문자열 크기+1 만큼 2진수를 만든다음에, 찾는 문자열을 만족하는 경우 출력 => Error: 제한시간 초과*/
/*그래서 풀이를 참조 => 이진문자열복원2.java에 풀었음. (DP)로 구현해야했던 문제*/
/*그냥 생각해봐도.. 최대 2^81번 반복해서 돌면 제한시간 초과인데..구현을 그래도 해보고싶었음..*/
