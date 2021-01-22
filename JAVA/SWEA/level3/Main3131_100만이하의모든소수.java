package level3;

public class Main3131_100만이하의모든소수 {

	public static void main(String[] args) {

		int N = 1000000;
		
		for(int i = 2; i <= N; i++) {
			boolean ck = true;
			for(int j = 2 ; j<= Math.sqrt(i); j++) {
				if(i % j == 0) {
					ck = false;
					break;
				}
			}
			if(ck) {
				System.out.printf(i + " ");
			}
		}
		
		
	}

}
