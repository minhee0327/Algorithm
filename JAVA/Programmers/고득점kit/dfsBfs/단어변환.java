package programmers.dfsbfs;

public class 단어변환 {

	public static void main(String[] args) {
		System.out.println(new Sol1().solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
		System.out.println(new Sol1().solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
	}
}


class Sol1{
	boolean [] visited;
	String target;
	int answer;
	String[] words;
	
	public int solution(String begin, String target, String[] words) {
		this.target = target;
		this.words = words;
		visited = new boolean[words.length];
		answer = Integer.MAX_VALUE;
		
		//target 단어가 words 배열에 있지 않으면 0 반환 후 종료
		if(!isTargetInWords()) {
			return 0;
		}
		
		//시작단어와 (가능한) 다음 단어를 찾아서 dfs돌림
        for(int i = 0; i < words.length; i++) {
        	if(isNext(begin, words[i])) {
        		dfs(i, words[i], 1);
        	}
        }
        
        return answer;
    }

	private boolean isTargetInWords() {
		for(int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) return true;
		}
		return false;
	}

	private  void dfs(int idx, String curWord, int cnt) {
		visited[idx] = true;
		//target값 찾았으면 여기까지 온 cnt랑 이전 answer랑 비교해서 작은값을 업데이트.
		if(curWord.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		//방문하지 않은 단어이고, 다음에 올 수 있는 단어라면 search
		for(int i = 0; i < words.length; i++) {
			if(!visited[i] && isNext(curWord, words[i])) {
				dfs(i, words[i], cnt+1);
				cnt-=1;
			}
		}
	
	}

	//다음에 가능한 단어인지 체크하는 method.
	//두 문자열이 2개 이상 다른 char값을 가졌으면 다음에 올 수 없음.
	private  boolean isNext(String prev, String nxt) {
		int cnt = 0;
		for(int i = 0; i < prev.length(); i++) {
			if(prev.charAt(i) != nxt.charAt(i)) {
				cnt ++;
			}
			if (cnt > 1) return false;
		}
		return true;
	}
}
