package Graph;

import java.io.*;
import java.util.*;

public class Main_B_13549_숨바꼭질3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N, M));
        br.close();
    }

    public static int bfs(int N, int M) {
        boolean[] visited = new boolean[100_001];
        Deque<Point> deque = new LinkedList<>();
        visited[N] = true;
        deque.offer(new Point(N, 0));

        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            if (cur.x == M) return cur.t;

            int nx = cur.x * 2;
            if (nx >= 0 && nx < 100_001 && !visited[nx]) { visited[nx] = true; deque.addFirst(new Point(nx, cur.t)); }
            nx = cur.x - 1;
            if (nx >= 0 && !visited[nx]) { visited[nx] = true; deque.addLast(new Point(nx, cur.t + 1)); }
            nx = cur.x + 1;
            if (nx <= M && !visited[nx]) { visited[nx] = true; deque.addLast(new Point(nx, cur.t + 1)); }
        }

        return -1;
    }

    static class Point {
        int x, t;

        Point(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }

}
