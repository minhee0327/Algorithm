package programmers.level2;

public class Sol7 {
    public static void main(String[] args) {
        System.out.println(new Solution7().solution( 15));
        System.out.println(new Solution7().solution( 18));
    }
}

class Solution7{
    //two pointer algorithm
    public int solution(int n){
        int cnt = 0;
        int sum = 1;
        int start = 1;
        int end = 1;

        while(end<=n && start <=n){
            if (sum == n) {
                cnt++;
                sum-= start++;
            } else if(sum> n) {
                sum-=start++;
            } else if(sum<n) {
                sum+=++end;
            }
        }
        return cnt;
    }

    //정수론: 연속한 자연수의 합으로 표현하는 방법의 수 = 주어진 수의 홀수 약수개와 같다.
    public int solution2(int n){
        int ans = 0;
        for(int i = 1; i <= n; i+=2){
            if(n % i == 0){
                ans++;
            }
        }
        return ans;
    }

    public int solution3(int n){
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            int temp = 0;
            for(int j = i; j <= n; j++){
                temp+= j;
                if(temp == n){
                    cnt++;
                }else if(temp>n){
                    break;
                }
            }
        }
        return cnt;
    }
}