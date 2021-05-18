package aloneBook.greedy;

import java.util.Arrays;
import java.util.Scanner;

//p92. 믄 수의 법칙 수열 이용
public class Sol1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int firstMax = arr[N-1];
        int secondMax = arr[N-2];

        int firstCount = M/(K+1) * K + (M % (K+1));
        int secondCont = M - firstCount;

        System.out.println(firstMax*firstCount + secondMax*secondCont);
    }
}

/*
* [first example]
* N = 5, M = 8, K = 3
* arr = 2,4,5,4,6
*
* [result]
* [6,6,6,5][6,6,6,5] = 46
*
* => [가장 큰 수 K 개, 두번째큰수 1개] 반복 되는 패턴이 보인다.
* 이 패턴의 길이(k+1)로 나눠떨어지는 경우에, 가장 큰수는 M / (k+1) * k 만큼 나온다.
* 나눠 떨어지지 않는 경우, 가장 큰 수는 뒤에 M % (k+1) 만큼 남아 있다.
* 따라서 가장 큰 수는 M/(k+1) * k + M%(k+1) 만큼 나온다.
*
* 또한 두번째 큰수는 전체길이 M 개 중 큰수가 나온만큼 제외해준만큼 나온다.
* */