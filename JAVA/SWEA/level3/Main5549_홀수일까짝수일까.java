package level3;

import java.util.Scanner;

public class Main5549_홀수일까짝수일까 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			String s = sc.next();
			
			sb.append("#");
			sb.append(t);
			if(s.charAt(s.length()-1)%2==0) {
				sb.append(" Even\n");
			}else {
				sb.append(" Odd\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}


/*핵심: 큰 수에서 홀,짝을 구할 때 맨 뒤 1자리만 보면 된다.*/