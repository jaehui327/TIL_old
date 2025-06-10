package BruteForce.BFS;

import java.io.*;
import java.util.*;

public class Main_B_16509_장군 {

    static class Point {
        int r;
        int c;
        int t;

        Point(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    static int[][] dr = { { 0, -1, -1 }, { 0, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 0, 1, 1 }, { 0, -1, -1 }, { -1, -1, -1 }, { -1, -1, -1 } };
    static int[][] dc = { { 1, 1, 1 }, { 1, 1, 1 }, { 0, 1, 1 }, { 0, -1, -1 }, { -1, -1, -1 }, { -1, -1, -1 }, { 0, -1, -1 }, { 0, 1, 1 } };

    static int bfs(int r, int c, int nr, int nc) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[10][9];
        queue.offer(new Point(r, c, 0));
        visited[r][c] = true;
        int answer = -1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 8; d++) {
                boolean canMove = true;
                int rr = cur.r;
                int cc = cur.c;

                for (int i = 0; i < 3; i++) {
                    rr += dr[d][i];
                    cc += dc[d][i];

                    if (rr < 0 || rr >= 10 || cc < 0 || cc >= 9) {
                        canMove = false;
                        break;
                    }
                    if (i < 2 && rr == nr && cc == nc) {
                        canMove = false;
                        break;
                    }
                }

                if (!canMove || visited[rr][cc])
                    continue;

                if (rr == nr && cc == nc) {
                    return cur.t + 1;
                }

                queue.offer(new Point(rr, cc, cur.t + 1));
                visited[rr][cc] = true;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int nr = Integer.parseInt(st.nextToken());
        int nc = Integer.parseInt(st.nextToken());
        System.out.println(bfs(r, c, nr, nc));
        br.close();
    }
}
