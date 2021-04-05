package programmers.dp;

public class Thievery {
    public static void main(String[] args) {
        System.out.println(new Sol4().solution(new int[] {1,2,3,1}));
    }
}

class Sol4{
    int [] stealFirst;  //첫번째 집 훔친 경우
    int [] stealSecond; //두번째 집 훔친 경우
    public int solution(int[] money){
        int arrLen = money.length;
        stealFirst = new int[arrLen];
        stealSecond = new int[arrLen];

        stealFirst[0] = money[0];       //첫 집 돈 저장
        stealFirst[1] = stealFirst[0];  //첫 집 털었으니까, 두번째 집은 못털고 첫번째 집에서 턴 금액 가지고 있음.

        stealSecond[0] = 0;             //두번째 집 털거니까 첫집에서는 0원
        stealSecond[1] = money[1];      //두번째 집 털었으니까 그 금액 저장

        for(int i = 2; i < arrLen; i++){    // 이전 집을 털었던 경우 | 전전집과 현재집을 턴 경우 중 최댓값 갱신해감.
            stealFirst[i] = Math.max(stealFirst[i-1], stealFirst[i-2] + money[i]);
            stealSecond[i] = Math.max(stealSecond[i-1], stealSecond[i-2] + money[i]);
        }

        //첫번째 집을 털기 시작한 경우에는 마지막 집을 털 수 없으니까 arrLen-2 위치의 값이 최대이고
        //두번째 집을 털기 시작한 경우에는 마지막 집을 털 수 있으니까 arrLen-1 위치의 값이 최대임.
        //둘 중 최대인 경우가 가장 많이 턴 경우!
        return Math.max(stealFirst[arrLen-2], stealSecond[arrLen-1]);
    }
}