package programmers.level2;
//  방금 그 곡
public class Sol14_1 {
    public static void main(String[] args) {
        System.out.println(new Solution14_1().solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(new Solution14_1().solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(new Solution14_1().solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}

class Solution14_1{
    String mm;

    public String solution(String m, String[] musicinfos) {
        //바뀐 m 담는 변수
        mm = changeM(m);
        int maxTime = 0;
        String answer = "(None)";

        for(int i = 0; i < musicinfos.length; i++){
            String[] infos = musicinfos[i].split(",");
            infos[3] = changeM(infos[3]);

            int intervals = getIntervals(infos[0], infos[1]);

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < intervals; j++){
                sb.append(infos[3].charAt(j%(infos[3].length())));
            }
            String realMusic = sb.toString();

            if(realMusic.contains(mm)){
                if(maxTime < intervals){
                    maxTime = intervals;
                    answer = infos[2];
                }
            }
        }
        return answer;
    }

    public int getIntervals(String a, String b){
        String[] aArr = a.split(":");
        String[] bArr = b.split(":");

        int hour = Integer.parseInt(bArr[0]) - Integer.parseInt(aArr[0]);
        int min = Integer.parseInt(bArr[1]) - Integer.parseInt(aArr[1]);

        return hour * 60 + min;
    }

    // A# -> a, B# -> b, ....
    public String changeM(String m){
        m = m.replaceAll("A#", "a");
        m = m.replaceAll("B#", "b");
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("E#", "e");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        return m;
    }
}