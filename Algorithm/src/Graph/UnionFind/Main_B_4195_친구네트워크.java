package Graph.UnionFind;

import java.io.*;
import java.util.*;

public class Main_B_4195_친구네트워크 {

    static Map<String, String> parent;
    static Map<String, Integer> cnt;

    static String find(String x) {
        if (parent.get(x) == x) return x;
        String nx = find(parent.get(x));
        parent.put(x, nx);
        return nx;
    }

    static void union(String x, String y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        parent.put(y, x);
        cnt.put(x, cnt.get(x) + cnt.get(y));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N;
        String x, y;

        for (int t = 0; t < T; t++) {
            parent = new HashMap<>();
            cnt = new HashMap<>();
            N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x = st.nextToken();
                y = st.nextToken();
                if (!parent.containsKey(x)) { parent.put(x, x); cnt.put(x, 1); }
                if (!parent.containsKey(y)) { parent.put(y, y); cnt.put(y, 1); }
                union(x, y);
                sb.append(cnt.get(find(x))).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
