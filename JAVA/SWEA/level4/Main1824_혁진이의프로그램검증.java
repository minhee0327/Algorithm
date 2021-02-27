package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1824_혁진이의프로그램검증 {
	static int R, C;
	static char[][] matrix;
	static boolean[][][][] visited; // x, y, dir, mem
	static boolean find, hasEnd;
	static int[] dx = {-1, 0, 1, 0}; //북,동,남,서 
	static int[] dy = { 0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T =Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			matrix = new char[R][C];
			visited = new boolean[R][C][4][16];
			find = false;
			hasEnd = false;

			for (int i = 0; i < R; i++) {
				matrix[i] = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					if (matrix[i][j] == '@') {
						hasEnd = true;
					}
				}
			}

			if (hasEnd) {
				search(0, 0, 1, 0);
			}
			
			if(find) {
				System.out.printf("#%d %s\n", t, "YES");
			}else {
				System.out.printf("#%d %s\n", t, "NO");
			}
		}
	}

	private static void search(int x, int y, int dir, int mem) {
		// @를 찾았으면 종료
		if (find) return;
		if (matrix[x][y] == '@') {
			find = true;
			return;
		}
		
		//방문 한적 있으면 패스
		if(visited[x][y][dir][mem]) return;
		//방문 체크
		visited[x][y][dir][mem] = true;

		//주어진 명령어 수행 및 현재 방향과 현재메모리 값 저장.
		int nowDir = dir;
		int nowMem = mem;
		switch(matrix[x][y]) {
			case '>': nowDir = 1; break;
			case 'v': nowDir = 2; break;
			case '<': nowDir = 3; break;
			case '^': nowDir = 0; break;
			case '_': nowDir = (mem == 0? 1: 3); break;
			case '|': nowDir = (mem == 0? 2: 0); break;
			case '+': nowMem = (mem == 15? 0: mem+1); break;
			case '-': nowMem = (mem == 0 ? 15: mem-1); break;
			 case '0':case '1':case '2':case '3':case '4': 
	        case '5':case '6':case '7':case '8':case '9':
	        	nowMem = matrix[x][y] - '0';
	        	break;
		}
		
		
		if(matrix[x][y] == '?') {
			for(int i = 0; i < 4 ; i++) {
				if(x + dx[i] <0) {
					search(R-1, y + dy[i], i, nowMem);
				}else if (x + dx[i] >= R) {
					search(0, y + dy[i], i , nowMem);
				}else if (y + dy[i] < 0) {
					search(x + dx[i], C-1, i, nowMem);
				}else if (y + dy[i] >= C) {
					search(x+ dx[i], 0, i, nowMem);
				}else {
                    search(x+dx[i],y+dy[i],i,nowMem);    
				}
			}
		}else {
			if(x + dx[nowDir] <0) {
				search(R-1, y + dy[nowDir], nowDir, nowMem);
			}else if (x + dx[nowDir] >= R) {
				search(0, y + dy[nowDir], nowDir , nowMem);
			}else if (y + dy[nowDir] < 0) {
				search(x + dx[nowDir], C-1, nowDir, nowMem);
			}else if (y + dy[nowDir] >= C) {
				search(x+ dx[nowDir], 0, nowDir, nowMem);
			}else {
				search(x+dx[nowDir], y + dy[nowDir], nowDir, nowMem);
			}
		}
	}
}

/*https://jaejin89.tistory.com/63 참조코드.*/
