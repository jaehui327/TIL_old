package Implementation.시뮬레이션;

import java.io.*;
import java.util.*;

public class Main_B_3190_뱀 {

    static int N;
    static int[][] map;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    static Map<Integer, Character> dir;
    static List<Point> snake;

    static int bfs() {
        int time = 0, d = 0, x = 0, y = 0, nx, ny;
        snake.add(new Point(0, 0));

        while (true) {
            time++;
            nx = x + dx[d];
            ny = y + dy[d];

            if (gameOver(nx, ny)) break;

            snake.add(new Point(nx, ny));
            if (map[ny][nx] == 1) map[ny][nx] = 0;
            else snake.remove(0);

            if (dir.containsKey(time)) {
                if (dir.get(time) == 'D') {
                    d += 1;
                    if (d == 4) d = 0;
                } else {
                    d -= 1;
                    if (d == -1) d = 3;
                }
            }

            x = nx;
            y = ny;
        }

        return time;
    }

    static boolean gameOver(int nx, int ny) {
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) return true;
        for (int i = 0; i < snake.size(); i++)
            if (nx == snake.get(i).x && ny == snake.get(i).y) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dir = new HashMap<>();
        snake = new ArrayList<>();
        int r, c, s; char d;

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            d = st.nextToken().charAt(0);
            dir.put(s, d);
        }

        System.out.println(bfs());
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
