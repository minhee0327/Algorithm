package programmers.level2;

//점프와 순간 이동
public class Sol20 {
    public static void main(String[] args) {
        System.out.println(new Solution20().solution(5));
        System.out.println(new Solution20().solution(6));
        System.out.println(new Solution20().solution(5000));
    }
}

class Solution20{
    public int solution(int n) {
        int ans = 0;

        while(n>0){
            if(n % 2 == 0){
                n/= 2;
            }else{
                n-=1;
                ans++;
            }
        }

        return ans;
    }
}