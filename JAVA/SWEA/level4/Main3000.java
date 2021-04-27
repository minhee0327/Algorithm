package swea.d4;

import java.util.*;

public class Main3000 {
    static final int MOD = 20171109;
    static Queue<Integer> left;
    static Queue<Integer> right;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();


        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int mid = sc.nextInt();
            int answer = 0;

            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                addNum(a, mid);
                addNum(b, mid);

                while (left.size() > right.size()) {
                    right.add(mid);
                    mid = left.poll();
                }
                while (left.size() < right.size()){
                    left.add(mid);
                    mid = right.poll();
                }

                answer = (answer + mid) % MOD;
            }

            System.out.printf("#%d %d\n", t, answer);
        }
    }

    public static void addNum(int num, int mid) {
        if (num > mid) {
            right.add(num);
        } else {
            left.add(num);
        }
    }
}


// 1. 첫 번째 그냥 리스트에 담고 계속 sort 해서 중앙값 더했더니 시간 초과
// 2. 문제 다시 읽어보니 최소 힙, 최대 힙 사용한대서 boj 키로거문제처럼 좌, 우에 queue 를 두고 계속 중앙값을 찾는 방향으로 해보자.
// 2-1. 왼쪽이 pop 할 때 커야하니까 최대힙, 오른쪽이 pop 할 때 작은 값 빼서 왼쪽으로 넣어야하니까 최소힙으로 구현했다.