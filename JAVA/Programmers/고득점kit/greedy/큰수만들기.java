package programmers.greedy;


public class 큰수만들기 {

	public static void main(String[] args) {
		System.out.println(solution("1924" , 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
		//testcase 12 error 
		System.out.println(solution("999", 2));
		System.out.println(solution("99991", 3));
		System.out.println(solution("111119", 3));
	}

	private static String solution(String number, int k) {
		boolean[] flag = new boolean[number.length()];
		
		for(int i = 0; i < number.length(); i++) {
			if(k<=0) {
				break;
			}
			
			if(number.length() - i > k) {
				for(int j = i+1; j< i+1+k; j++) {
					if(number.charAt(i) <number.charAt(j)) {
						flag[i] = true;
						k--;
						break;
					}
				}
			}else {
				flag[i] = true;
			}
			
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < number.length();i++) {
			if(!flag[i]) {
				sb.append(number.charAt(i));
			}
		}
		
		return sb.toString();
	}

}

