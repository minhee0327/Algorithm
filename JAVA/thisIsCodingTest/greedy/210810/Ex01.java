package thisIsCoding3.greedy;

//p.87 3-1 거스름돈
public class Ex01 {
    public static void main(String[] args) {

        int[] arr = {500, 100, 50, 10};
        int n = 1260;
        int cnt = 0;

        for(int a: arr){
            cnt += n/a;
            n %= a;
        }

        System.out.println(cnt);
    }
}
