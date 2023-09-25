package Graph.UnionFind;

import java.io.*;
import java.util.*;
public class Main_B_1976_여행가자 {

    static int[] parent;
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        else parent[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int connect;
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                connect = Integer.parseInt(st.nextToken());
                if (connect == 1) union(i, j);
            }
        }

        int[] path = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) path[i] = Integer.parseInt(st.nextToken());
        boolean isAvailable = true;

        int root = find(path[0]);
        for (int i = 1; i < M; i++) {
            if (root != find(path[i])) { isAvailable = false; break; }
        }

        if (isAvailable) System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }
}
