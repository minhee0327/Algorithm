package dailyChallenge;

import java.util.Scanner;

public class Operators {

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double meal_cost = scanner.nextDouble();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tip_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tax_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solve(meal_cost, tip_percent, tax_percent);

        scanner.close();
    }

    static void solve(double meal_cost, int tip_percent, int tax_percent) {
    	double tip = (meal_cost * tip_percent) /100;
    	double tax = (meal_cost * tax_percent) /100;
    	int total = (int) Math.round(meal_cost + tip + tax);
    	System.out.println(total);
    }
}


/*
 * [문제 요약]
 * meal_cost, tip_percent, tax_percent 입력 받기
 * 팁: meal_cost * tip_percent /100
 * 세금: meal_cost * tax_percent / 100
 * 
 * 총 내야할 금액 : meal_cost + 팁 + 세금
 * 총 내야할 금액을 정수로 나타내세요
 * 
 */