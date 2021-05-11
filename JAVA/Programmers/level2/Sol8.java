package programmers.level2;
//땅따먹기
public class Sol8 {
    public static void main(String[] args) {
        System.out.println(new Solution8().solution(new int[][]{{1,2,3,5}, {5,6,7,8}, {4,3,2,1}}));
    }
}

class Solution8{
    // 두번째 행부터 이전에 밟지 않은 땅 중에서 가장 큰 값을 합해주는 방식
    public int solution(int[][] land){
        int n = land.length;
        for(int i = 1; i < n; i++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        int answer = 0;
        for(int i = 0; i < 4; i++){
            answer = Math.max(land[n-1][i], answer);
        }

        return answer;
    }


    //search 로 구현했으나 시간 초과가 떴다..
    /*
    int r, c;
    int[][] map;
    int answer = Integer.MIN_VALUE;

    int solution(int[][] land){
        r = land.length;
        c = land[0].length;
        map= land;

        for(int i = 0; i < c; i++){
            search(0, i, land[0][i]);
        }
        return answer;
    }

    public void search(int x, int y, int sum){
        if(x == r-1){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0; i < c; i++){
            if(i != y){
                search(x+1, i, sum + map[x+1][i]);
            }
        }
    }
    */


}