import java.io.*;
import java.util.*;

public class Main_메이즈러너 {

	static int N, M, K;
	static int[][] map, copy;
	
	static Point[] participants;
	static Point exit;
	
	static int answer;
	
	static Point square;
	static int squareSize;
	
	static void solution() {
		for (int k = 1; k <= K; k++) {
			moveParticipants(); // 참가자 이동 
			if (isAllEscape()) break; // 모든 참가자 탈출하면 즉시 종료
			findSquare(); // 출구와 참가자 최소 1명을 포함한 정사각형 찾기 
			rotateSquare(); // 회전 
		}
	}
	
	static void moveParticipants() {
		for (int i = 1; i <= M; i++) {
			if (participants[i].x == exit.x && participants[i].y == exit.y) continue;
			if (participants[i].y != exit.y) { // 행이 다를 경우 
				int ny = participants[i].y;
				
				if (exit.y > ny) ny++; // 아래로 
				else ny--; // 위로 
				
				if (map[ny][participants[i].x] == 0) { // 빈칸이라면 이동 
					participants[i].y = ny;
					answer++;
					continue;
				}
			}
			if (participants[i].x != exit.x) { // 열이 다를 경우 
				int nx = participants[i].x;
				
				if (exit.x > nx) nx++; // 오른쪽 
				else nx--; // 왼쪽 
				
				if (map[participants[i].y][nx] == 0) { // 빈칸이라면 이동 
					participants[i].x = nx;
					answer++;
					continue;
				}
			}
		}
	}
	
	static boolean isAllEscape() {
		boolean isEscape = true;
		for (int i = 1; i <= M; i++) {
			if (!(participants[i].x == exit.x && participants[i].y == exit.y)) {
				isEscape = false; 
				break;
			}
		}
		return isEscape;
	}
	
	static void findSquare() {
		for (int size = 2; size <= N; size++) { // 2 * 2 부터 N * N 까지 
			for (int y = 1; y <= N - size + 1; y++) { // r 좌표 최소순 
				for (int x = 1; x <= N - size + 1; x++) { // c 좌표 최소순 
					int nx = x + size - 1;
					int ny = y + size - 1;
					
					if (!(x <= exit.x && exit.x <= nx && y <= exit.y && exit.y <= ny)) continue; // 출구를 포함하고 있지 않다면 건너뛰기 
					
					boolean hasParticipants = false;
					for (int i = 1; i <= M; i++) {
						if (participants[i].x == exit.x && participants[i].y == exit.y) continue; // 이미 탈출한 참가자 건너뛰기 
						if (x <= participants[i].x && participants[i].x <= nx && y <= participants[i].y && participants[i].y <= ny) {
							hasParticipants = true;
							break;
						}
					}
					
					if (!hasParticipants) continue; // 정사각형 내에 참가자가 없다면 다시 탐색 
					
					square = new Point(x, y); // 정사각형 시작 위치 
					squareSize = size; // 정사각형 크기 
					return; // 찾았으면 종료 
				}
			}
		}
	}
	
	static void rotateSquare() {
		for (int y = square.y; y < square.y + squareSize; y++) 
			for (int x = square.x; x < square.x + squareSize; x++) 
				if (map[y][x] > 0) map[y][x]--; // 회전 시 벽 -1 
			
		
		for (int y = square.y; y < square.y + squareSize; y++) 
			for (int x = square.x; x < square.x + squareSize; x++) 
				copy[x - square.x + square.y][squareSize - y + square.y + square.x - 1] = map[y][x];
				
		for (int y = square.y; y < square.y + squareSize; y++) 
			for (int x = square.x; x < square.x + squareSize; x++) 
				map[y][x] = copy[y][x];
		
		for (int i = 1; i <= M; i++) {
			if (square.x <= participants[i].x && participants[i].x < square.x + squareSize &&
					square.y <= participants[i].y && participants[i].y < square.y + squareSize) {
				int x = participants[i].x;
				int y = participants[i].y;
				participants[i].y = x - square.x + square.y;
				participants[i].x = squareSize - y + square.y + square.x - 1;
				
			}
		}
		
		int x = exit.x;
		int y = exit.y;
		exit.y = x - square.x + square.y;
		exit.x = squareSize - y + square.y + square.x - 1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		copy = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		participants = new Point[M + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			participants[i] = new Point(x, y);
		}
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		exit = new Point(x, y);
		
		solution();
		sb.append(answer).append("\n");
		sb.append(exit.y).append(" ").append(exit.x);
		System.out.println(sb);
		br.close();
	}
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
