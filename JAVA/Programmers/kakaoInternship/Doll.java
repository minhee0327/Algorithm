package kakao.internship;

import java.util.Stack;

//크레인 인형 뽑기 게임
public class Doll {
    public static void main(String[] args) {
        System.out.println(new Sol1().solution(new int[][] {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }
}

class Sol1{
    public int solution(int[][] board, int[] moves) {
        int count = 0;
        int N = board.length;                   //정사각형 사이즈
        Stack<Integer> stack = new Stack<>();   //바구니

        for(int m: moves){
            m--;
            for(int i = 0; i < N ; i++){
                if(board[i][m] != 0){
                    int block = board[i][m];    //크레인으로 뽑은 블록
                    board[i][m] = 0;            //꺼낸 곳은 0으로 초기화 해주기

                    if(stack.isEmpty()){
                        stack.add(block);
                    }else{
                        if(stack.peek() == block){
                            stack.pop();
                            count+=2;
                        }else{
                            stack.add(block);
                        }
                    }
                    break;                      // 뽑은 다음 stack 에서 처리했다면 더 볼 필요 없음 move 확인하기.
                }
            }
        }
        return count;
    }

}