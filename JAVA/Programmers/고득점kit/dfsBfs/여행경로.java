package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 여행경로 {

	public static void main(String[] args) {
		System.out
				.println(Arrays.toString(new Sol2().solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } })));
		System.out.println(Arrays.toString(new Sol2().solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" },
				{ "ATL", "ICN" }, { "ATL", "SFO" } })));
	}

}

class Sol2 {
	String[] answer;
	boolean[] visited;
	String[][] tickets;
	String route;
	List<String> candidateAns;
	
	public String[] solution(String[][] tickets) {
		this.tickets = tickets;
		this.candidateAns = new ArrayList<>();
		
		route = "";
		
		for(int i = 0; i < tickets.length; i++) {
			this.visited = new boolean[tickets.length];
			String start = tickets[i][0];
			String end = tickets[i][1];
			if(start.equals("ICN")) {
				route+= start +",";
				visited[i] = true;
				dfs(end, 1);
				route="";
			}
		}
		Collections.sort(candidateAns);
		answer = candidateAns.get(0).split(",");
		return answer;
	}

	private void dfs(String prevEnd, int count) {
		route+= prevEnd +",";
		if(count == tickets.length) {
			candidateAns.add(route);
			return;
		}
		
		for(int i = 0; i < tickets.length; i++) {
			String curStart = tickets[i][0];
			String curEnd = tickets[i][1];
			if(!visited[i] && prevEnd.equals(curStart)) {
				visited[i] = true;
				dfs(curEnd, count+1);
				visited[i] = false;
				route = route.substring(0, route.length() - 4);
			}
		}
	}
}