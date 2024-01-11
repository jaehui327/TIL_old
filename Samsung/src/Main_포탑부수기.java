import java.io.*;
import java.util.*;

public class Main_포탑부수기 {
	
	static int N, M, K;
	static int[][] map, attackTime;
	static int[] dx = { 1, 0, -1, 0, 1, -1, -1, 1 }, dy = { 0, 1, 0, -1, 1, 1, -1, -1 }; // 우 하 좌 상 우하 좌하 좌상 우상 
	static List<Turret> turrets; // 살아있는 터렛
	static int[][] backX, backY;
	static boolean[][] selected;
	
	static void setTurrets() { // 3. 포탑 부서짐 
		turrets = new ArrayList<>();
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] > 0) // 부서지지 않은 포탑 
					turrets.add(new Turret(x, y, attackTime[y][x], map[y][x]));
			}
		}
		Collections.sort(turrets);
	}
	
	static boolean lazerAttack(Point from, Point to) {
		boolean isAttack = false;
		boolean[][] visited = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();
		visited[from.y][from.x] = true;
		queue.offer(new Point(from.x, from.y));

		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if (cur.x == to.x && cur.y == to.y) {
				isAttack = true;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = (cur.x + dx[d] + M) % M;
				int ny = (cur.y + dy[d] + N) % N;
				
				if (visited[ny][nx] || map[ny][nx] <= 0) continue; // 방문한 적 있거나 부서진 터렛이면 건너뛰기 
				
				visited[ny][nx] = true;
				queue.offer(new Point(nx, ny));
				backX[ny][nx] = cur.x;
				backY[ny][nx] = cur.y;
				
			}
		}
		
		
		if (!isAttack) return false; // 레이저 공격 실패 
		
		// 공격 
		map[to.y][to.x] -= map[from.y][from.x]; // 공격 대상 공격력 - 공격자 공격력 
		selected[to.y][to.x] = true;
		int nx = backX[to.y][to.x];
		int ny = backY[to.y][to.x];
		while (true) {
			if (nx == from.x && ny == from.y) // 공격자 만나면 끝 
				break;
			
			map[ny][nx] -= map[from.y][from.x] / 2; // 레이저 경로 터렛 공격력 - 공격자 공격력 / 2 
			selected[ny][nx] = true; // 공격받은 터렛으로 표시 
			int x = backX[ny][nx];
			int y = backY[ny][nx];
			nx = x; 
			ny = y;
		}
		
		return true;
	}
	
	static void turretAttack(Point from, Point to) {
		map[to.y][to.x] -= map[from.y][from.x]; // 공격 대상 공격력 - 공격자 공격력 
		selected[to.y][to.x] = true;
		
		for (int d = 0; d < 8; d++) {
			int nx = (to.x + dx[d] + M) % M;
			int ny = (to.y + dy[d] + N) % N;
			
			if (nx == from.x && ny == from.y) continue; // 공격자 건너뛰기 
			if (map[ny][nx] <= 0) continue; // 부서진 터렛 건너뛰기 
			
			map[ny][nx] -= map[from.y][from.x] / 2; // 8방향 포탑 공격력 - 공격자 공격력 / 2 
			selected[ny][nx] = true;
		}
	}
	
	static void repair() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] <= 0) continue; // 부서진 포탑 
				if (selected[y][x]) continue; // 공격자 또는 공격 피해 받은 포탑
				map[y][x]++; // 공격력 1 증가 
			}
		}
	}
	
	static int getMax() {
		int max = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				max = Math.max(max, map[y][x]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		attackTime = new int[N][M];
		
		backX = new int[N][M];
		backY = new int[N][M];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 1; k <= K; k++) {
			setTurrets(); // 3. 포탑 부서짐 (포탑 정렬)
			if (turrets.size() == 1) // 남은 포탑이 1개 뿐이라면 즉시 종료 
				break;
			
			// 1. 공격자 선정 
			Point from = new Point(turrets.get(0).x, turrets.get(0).y); // 공격자 
			attackTime[from.y][from.x] = k; // 공격 시간 갱신 
			map[from.y][from.x] += N + M; // 공격자 공격력 + (N + M) 
			Point to = new Point(turrets.get(turrets.size() - 1).x, turrets.get(turrets.size() - 1).y); // 공격 대상 
			
			// 2. 공격 
			selected = new boolean[N][M];
			selected[from.y][from.x] = true;
			if (!lazerAttack(from, to)) // 레이저 공격 
				turretAttack(from, to); // 터렛 공격 
			
			// 4. 포탑 정비 
			repair();
		}
		
		System.out.println(getMax());
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
	
	static class Turret implements Comparable<Turret> {
		int x; // 열 
		int y; // 행 
		int t; // 최근 공격한 시간 
		int power; // 공격력 
		
		Turret(int x, int y, int t, int power) {
			this.x = x;
			this.y = y;
			this.t = t;
			this.power = power;
		}

		@Override
		public int compareTo(Turret t) {
			if (this.power != t.power) return this.power - t.power; // 1. 공격력이 낮은 포탑 
			if (this.t != t.t) return t.t - this.t; // 2. 가장 최근에 공격한 포탑 
			if (this.x + this.y != t.x + t.y) return (t.x + t.y) - (this.x + this.y); // 3. 행과 열의 합이 가장 큰 포탑 
			return t.x - this.x; // 4. 열 값이 가장 큰 포탑 
		}
	}
	
	

}
