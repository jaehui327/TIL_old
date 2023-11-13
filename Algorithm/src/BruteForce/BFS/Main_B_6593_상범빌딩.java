package BruteForce.BFS;

import java.io.*;
import java.util.*;

public class Main_B_6593_상범빌딩 {

    static class Point {
        int l, r, c, t;

        Point(int l, int r, int c, int t) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    static int[] dl = { 0, 0, 0, 0, 1, -1 }, dr = { 0, 0, 1, -1, 0, 0 }, dc = { 1, -1, 0, 0, 0, 0 };

    public static int bfs(int L, int R, int C, char[][][] map, Point start) {
        int time = 0;
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];
        queue.offer(start);
        visited[start.l][start.r][start.c] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (map[cur.l][cur.r][cur.c] == 'E') {
                time = cur.t;
                break;
            }

            for (int d = 0; d < 6; d++) {
                int nl = cur.l + dl[d];
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (map[nl][nr][nc] == '#' || visited[nl][nr][nc]) continue;
                queue.offer(new Point(nl, nr, nc, cur.t + 1));
                visited[nl][nr][nc] = true;
            }

        }

        return time;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] map = new char[L][R][C];
            Point start = null;

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    map[l][r] = br.readLine().toCharArray();
                    for (int c = 0; c < C; c++) {
                        if (map[l][r][c] == 'S')
                            start = new Point(l, r, c, 0);
                    }
                }
                br.readLine();
            }

            int time = bfs(L, R, C, map, start);
            if (time == 0) sb.append("Trapped!\n");
            else sb.append("Escaped in ").append(time).append(" minute(s).\n");
        }

        System.out.println(sb);
        br.close();
    }

}
