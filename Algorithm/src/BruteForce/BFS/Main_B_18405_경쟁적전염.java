package BruteForce.BFS;

import java.io.*;
import java.util.*;

public class Main_B_18405_경쟁적전염 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

    public static int solution(int N, int[][] map, int S, int X, int Y) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] copy = new int[N][N];

        for (int t = 0; t < S; t++) {
            queue = new LinkedList<>();

            copy = new int[N][N];
            for (int i = 0; i < N; i++) copy[i] = map[i].clone();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] || map[i][j] == 1001) continue;
                    queue.offer(new Point(j, i));
                    visited[i][j] = true;
                }
            }

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (map[ny][nx] < 1001 || copy[ny][nx] < map[cur.y][cur.x]) continue;
                    copy[ny][nx] = map[cur.y][cur.x];
                }
            }

            for (int i = 0; i < N; i++) map[i] = copy[i].clone();
        }

        return map[X - 1][Y - 1] == 1001 ? 0 : map[X - 1][Y - 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) map[i][j] = 1001;
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, map, S, X, Y));
        br.close();
    }
}
