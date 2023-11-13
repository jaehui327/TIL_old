package BruteForce.BFS;

import java.io.*;
import java.util.*;

public class MainB_2589_보물섬 {
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
    static int max;

    static void bfs(int x, int y, int N, int M, char[][] map) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        int[][] visited = new int[N][M];
        visited[y][x] = 1;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (map[ny][nx] == 'W' || visited[ny][nx] > 0) continue;
                queue.offer(new Point(nx, ny));
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
                max = Math.max(max, visited[ny][nx]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 'L') bfs(j, i, N, M, map);

        System.out.println(max - 1);
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
