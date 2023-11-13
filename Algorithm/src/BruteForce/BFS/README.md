# BFS(Breadth First Search)

너비 우선 탐색이란 시작 정점을 방문한 후 시작 정점에 인접한 모든 정점들을 우선 방문하는 방법입니다.<br>
더 이상 방문하지 않은 정점이 없을 때까지 방문하지 않은 모든 정점ㄷ르에 대해 너비 우선 검색을 적용합니다. <br>
선입선출(FIFO) 원칙으로 탐색하므로, Queue를 사용하여 레벨 순서대로 접근합니다. <br><br>

출발 노드에서 목표 노드까지의 최단 길이 경로를 보장합니다. <br><br>

경로가 매우 길 경우에 탐색 가지가 급격히 증가하므로, 많은 기억 공간이 필요할 수 있습니다. <br>
무한 그래프의 경우 해를 찾지 못하고 끝내지도 못한다는 단점이 있습니다. <br><br>

```
✅ 시간 복잡도
인접 리스트로 표현된 그래프: O(N + E)
인접 행렬로 표현된 그래프: O(N * N)
```

### [백준 18405번 경쟁적 전염](https://www.acmicpc.net/problem/18405)

```java
import java.io.*;
import java.util.*;

public class Main {

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
```

### [백준 2589번 보물섬](https://www.acmicpc.net/problem/2589)

```java
import java.io.*;
import java.util.*;

public class Main {
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
```

### [백준 16509번 장군](https://www.acmicpc.net/problem/16509)

```java
import java.io.*;
import java.util.*;

public class Main {

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
```

### [백준 6593번 상범 빌딩](https://www.acmicpc.net/problem/6593)

```java
import java.io.*;
import java.util.*;

public class Main {

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
```
