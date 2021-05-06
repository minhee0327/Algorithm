package kakao.internship;

//키패드 누르기
public class KeyPad {
    public static void main(String[] args) {
        System.out.println(new Solution2().solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right"));
        System.out.println(new Solution2().solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left"));
        System.out.println(new Solution2().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},"right"));
    }
}

class Solution2{
    int[] leftHand = {3,0};
    int[] rightHand = {3,2};
    int[][] xy;
    StringBuilder sb;

    public String solution(int[] numbers, String hand) {
        sb = new StringBuilder();
        // 번호별 좌표 mapping
        xy = new int[10][2];
        xy[0][0] = 3;
        xy[0][1] = 1;
        for(int i = 1; i <xy.length; i++){
            xy[i][0] = (i-1) / 3;
            xy[i][1] = (i-1) % 3;
        }

        for(int n: numbers){
            if("147".contains(String.valueOf(n))){
                moveLeft(n);
            }else if("369".contains(String.valueOf(n))){
                moveRight(n);
            }else{
                int leftDist = getDistance(leftHand, xy[n]);
                int rightDist = getDistance(rightHand, xy[n]);
                if(leftDist==rightDist){
                    if(hand.equals("right")){
                        moveRight(n);
                    }else{
                        moveLeft(n);
                    }
                }else if (leftDist< rightDist){
                    moveLeft(n);
                }else {
                    moveRight(n);
                }
            }
        }

        return sb.toString();
    }
    // 오른 손 움직이기
    private void moveRight(int n){
        rightHand[0] = xy[n][0];
        rightHand[1] = xy[n][1];
        sb.append("R");
    }
    // 왼손 움직이기
    private void moveLeft(int n){
        leftHand[0] = xy[n][0];
        leftHand[1] = xy[n][1];
        sb.append("L");
    }
    private int getDistance(int[] leftHand, int[] nxt) {
        return Math.abs(leftHand[0]-nxt[0]) + Math.abs(leftHand[1] - nxt[1]);
    }
}