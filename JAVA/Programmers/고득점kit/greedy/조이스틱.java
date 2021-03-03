package programmers.greedy;

public class 조이스틱 {

	public static void main(String[] args) {
		System.out.println(solution("JEROEN")); //56
		System.out.println(solution("JAN")); //23
		System.out.println(solution("JAZ")); //11
		System.out.println(solution("AAA")); //0
		System.out.println(solution("ZZZ")); //5
		System.out.println(solution("BBBAAAB")); //9
		System.out.println(solution("ABABAAAAABA")); //11
		
	}
	public static int solution(String name) {
        int answer = 0;
        
        int[] arr = new int[name.length()];
        int total = 0;
        for(int i = 0; i < name.length(); i++) {
        	arr[i] = Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
        	total += arr[i];
        }
        
        int lCnt = -1, rCnt = -1;
        int ltotal = 0, rtotal = 0;
        
        //오른쪽으로 간경우 [이거는 전체길이 -1] 로 간단히 구해도 좋을 듯하다.
        for(int i = 0; i < name.length(); i++) {
        	rtotal+=arr[i];
        	rCnt ++;
        	if(rtotal == total) {
        		break;
        	}
        }
        
        //왼쪽으로 간경우
        ltotal += arr[0];
        lCnt ++;
        for(int i = name.length()-1; i>0 ; i--) {
        	ltotal+= arr[i];
        	lCnt ++;
        	if(ltotal == total) {
        		break;
        	}
        }
        
        //A가 연달아 나오는 경우 고려한 코드(추가)
        int Ccnt = -1, cTotal = 0;
        if(name.contains("AAA")) {
        	for(int i = 0; i < name.indexOf("AAA"); i++){
        		Ccnt++;
        		cTotal += arr[i];
        	}
        	Ccnt*=2;
        	for(int i = name.length()-1; i> name.lastIndexOf("AAA"); i--) {
        		Ccnt++;
        		cTotal += arr[i];
        		if(cTotal == total) {
        			break;
        		}
        	}
        			
        }
        
        answer = Ccnt == -1 ? (total + Math.min(lCnt, rCnt)): total + Math.min(Ccnt, Math.min(lCnt, rCnt));
        return answer;
    }
}

/*
 * [내가 생각한 방법]
 * 1. 먼저 각 알파벳을 위아래로 얼마나 이동해야하는지 체크하면서, 위, 아래중 작은 값으로 배열에 저장.(arr) 
 *    & 총 위아래 움직여야하는 값 저장(total)
 * 2. 왼쪽, 오른쪽으로 움직이면서 총 움직이는 값에서 위아래 값을 빼주고
 *   2-1. total이 0이 되었으면 이동 중지
 *   2-1. 왼, 오 값 중 작은값 리턴
 *   
 *   
 * [돌아가는 방법을 생각하지 못해서 TC 11이 걸렸다.]
 * 예를들어 연달아 A가 나오면 돌아가는 경우도 있는데 그 중 오른쪽으로 갔다가 왼쪽으로 간 경우만 고려하면 되니까 코드를 추가해봤다.
 * 3. 보완책으로 AAA가 contains된 string일 경우만 해당 위치에서 돌아가는 값으로 test 해서 통과는 됬다;
 * 다만 TC가 모든 경우를 고려한 것인지 판단이 잘 되지 않아서 다른 사람의 풀이 참조가 필요하다.
 * 
 */