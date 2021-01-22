package dailyChallenge;

import java.util.Scanner;

public class DataType {

	public static void main(String[] args) {
		 	int i = 4;
	        double d = 4.0;
	        String s = "HackerRank ";
			
	        Scanner scan = new Scanner(System.in);
	       
	        int integerVal = scan.nextInt();
	        double doubleVal = scan.nextDouble();
	        scan.nextLine();
	        
	        String strVal = scan.nextLine();
	        System.out.println(i + integerVal);
			System.out.println(Math.round((d + doubleVal)* 10)/10.0);
	        System.out.println(strVal);
	        
	        scan.close();
	}

}

/* [문제요약]
 * 정수, 소수, 문자를 입력받아서 연결해서 출력하세요
 * 
 * [내가 놓친 부분]
 * 1. nextDouble, nextInt() 사용시 개행문자(\n)이 버퍼에 담겨있을 수 있다. nextLine()으로 개행문자를 받고, 다음 입력을 받자.
 * 
 */
