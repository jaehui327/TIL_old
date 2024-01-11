package BruteForce.BFS;

import java.io.*;
import java.util.*;

public class Main_B_30024_옥수수밭 {

    static class Corn implements Comparable<Corn> {
        int x, y, value;

        Corn(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Corn o) {
            return o.value - this.value;
        }
    }

    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

    public static void bfs(StringBuilder sb, int N, int M, int[][] map, boolean[][] visited, PriorityQueue<Corn> pq, int K) {
        for (int i = 0; i < K; i++) {
            Corn cur = pq.poll();
            sb.append(cur.y + 1).append(" ").append(cur.x + 1).append("\n");

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx]) continue;
                pq.offer(new Corn(nx, ny, map[ny][nx]));
                visited[ny][nx] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Corn> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                    pq.offer(new Corn(j, i, map[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        bfs(sb, N, M, map, visited, pq, K);

        System.out.println(sb);
        br.close();
    }

}
