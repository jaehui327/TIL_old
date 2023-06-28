package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_B_16236_아기상어 {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int t;

        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        @Override
        public int compareTo(Point o) {
            return this.t == o.t ? this.y == o.y ? this.x - o.x : this.y - o.y : this.t - o.t;
        }
    }

    static int[] dx = { 0, -1, 1, 0 }, dy = { -1, 0, 0, 1 };
    static int answer = 0; // 총 소요 시간
    static int cnt = 0; // 먹은 물고기 수
    static int size = 2; // 아기상어 크기

    public static int babyShark(int N, int[][] map, Point shark) {
        while (true) {
            Point p = bfs(N, map, shark);
            if (p.x == shark.x && p.y == shark.y) break;
            shark = p;
        }

        return answer;
    }

    public static Point bfs(int N, int[][] map, Point shark) {
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        visited[shark.y][shark.x] = true;
        queue.offer(new Point(shark.x, shark.y, 0));

        PriorityQueue<Point> fishes = new PriorityQueue<>();

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위 체크
                if (visited[ny][nx] || map[ny][nx] > size) continue; // 방문 여부, 아기상어보다 크면 못지나감

                if (map[ny][nx] == 0 || map[ny][nx] == size) { // 빈칸이거나 크기가 같으면 지나감
                    visited[ny][nx] = true; // 방문 체크
                    queue.offer(new Point(nx, ny, cur.t + 1));
                } else { // 크기가 작은 물고기일 때
                    fishes.offer(new Point(nx, ny, cur.t + 1));
                    visited[ny][nx] = true;
                }
            }
        }

        if (fishes.isEmpty()) return shark;

        Point fish = fishes.poll();
        map[shark.y][shark.x] = 0; // 아기 상어 위치 갱신
        map[fish.y][fish.x] = 9;
        shark = new Point(fish.x, fish.y, 0);

        answer += fish.t; // 이동 시간 증가

        if (cnt + 1 == size) { // 자신의 크기와 같은 수의 물고기를 먹을 때
            cnt = 0;
            size += 1; // 크기 증가
        } else cnt += 1;

        return shark;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        Point shark = null;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) shark = new Point(j, i, 0); // 아기 상어 위치
            }
        }

        System.out.println(babyShark(N, map, shark));
        br.close();
    }
}
