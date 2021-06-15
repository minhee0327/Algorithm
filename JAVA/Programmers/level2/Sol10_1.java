package programmers.level2;
//n 진수 게임
public class Sol10_1 {
    public static void main(String[] args) {
        System.out.println(new Solution10_1().solution(2, 4, 2, 1));
        System.out.println(new Solution10_1().solution(16, 16, 2, 1));
        System.out.println(new Solution10_1().solution(16, 16, 2, 2));
    }
}

class Solution10_1{
    //n: 진법, t: 미리구하고자하는 갯수, m: 인원, p: 내 순서
    public String solution(int n, int t, int m, int p) {
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < t * m; i++){
            temp.append(makeNum(i, n));
        }
        String s = temp.toString();
        StringBuilder answer = new StringBuilder();
        int q = p -1 ;

        for(int i = 0; i < t; i++){
            answer.append(s.charAt(q));
            q += m;
        }

        return answer.toString();
    }

    // x: 변환하려는 숫자, n: 진법
    public String makeNum (int x, int n){
        StringBuilder str = new StringBuilder();
        char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while(x/n!=0){
            str.insert(0, c[x % n]);
            x/=n;
        }
        //몫이 0일 때 나머지 추가
        str.insert(0, c[x%n]);
        return str.toString();
    }

}
//참조: https://twoearth.tistory.com/13
