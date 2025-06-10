package Implementation.구현;

import java.io.*;
import java.util.*;

public class Main_B_17086_아기상어2 {

    static class Point {
        int x;
        int y;
        int d;

        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 }, dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public static int bfs(int N, int M, int x, int y, int[][] map) {
        int distance = 0;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new Point(x, y, 0));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (map[cur.y][cur.x] == 1) {
                distance = cur.d;
                break;
            }

            for (int d = 0; d < 8; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx]) continue;
                queue.offer(new Point(nx, ny, cur.d + 1));
                visited[ny][nx] = true;
            }
        }

        return distance;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) continue;
                answer = Math.max(answer, bfs(N, M, j, i, map));
            }
        }

        System.out.println(answer);
        br.close();
    }
}
