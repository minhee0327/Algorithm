package programmers.hash;

import java.util.Arrays;

public class 전화번호목록 {

	public static void main(String[] args) {
		
		System.out.println(solution(new String[] { "119", "97674223", "1195524421" }));
		System.out.println(solution(new String[] { "123", "456", "789" }));
		System.out.println(solution(new String[] { "12", "123", "1235", "567", "88" }));

		System.out.println(solution1(new String[] { "119", "97674223", "1195524421" }));
		System.out.println(solution1(new String[] { "123", "456", "789" }));
		System.out.println(solution1(new String[] { "12", "123", "1235", "567", "88" }));
	}

	private static boolean solution(String[] phone_book) {
		boolean ret = true;
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i].length() < phone_book[i+1].length() 
	                &&phone_book[i].hashCode() == phone_book[i + 1].substring(0, phone_book[i].length()).hashCode()) {
				ret = false;
				break;
			}
		}

		return ret;
	}

	private static boolean solution1(String[] phone_book) {
		boolean ret = true;
		Arrays.sort(phone_book);

		//숫자인 String은 앞에서부터 char로 비교해서 오름차로 표현함. 
		for (int i = 0; i < phone_book.length-1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				ret = false;
				break;
			}
		}

		return ret;
	}
}
