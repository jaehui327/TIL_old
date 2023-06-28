package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_B_2638_치즈 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

    static int solution(int N, int M, int[][] map) {
        int answer = 0;

        while(isNotEmpty(N, M, map)) {
            bfs(N, M, map);
            answer += 1;
        }

        return answer;
    }

    public static  void bfs(int N, int M, int[][] map) {
        List<Point> list = new ArrayList<>();

        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Point(0, 0));

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (visited[ny][nx]) continue;

                if (map[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.offer(new Point(nx, ny));
                } else {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = nx + dx[k];
                        int y = ny + dy[k];
                        if (map[y][x] == 0 && visited[y][x]) cnt += 1;
                        if (cnt >= 2) {
                            visited[ny][nx] = true;
                            list.add(new Point(nx, ny));
                            break;
                        }
                    }
                }
            }
        }
        for (Point p : list) map[p.y][p.x] = 0;
    }

    public static boolean isNotEmpty(int N, int M, int[][] map) {
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) if (map[i][j] == 1) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, map));

        br.close();

    }
}
