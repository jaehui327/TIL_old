package Graph.MST.Kruskal;

import java.io.*;
import java.util.*;

public class Main_B_1197_최소스패닝트리 {


    static int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        int nx = find(parent[x], parent);
        parent[x] = nx;
        return nx;
    }

    static boolean union(int x, int y, int[] parent) {
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) return false;
        parent[y] = x;
        return true;
    }

    static int kruskal(int V, int E, Edge[] edges, int[] parents) {
        int answer = 0, cnt = 0;
        for (int i = 1; i <= V; i++)
            parents[i] = i;

        for (Edge edge: edges) {
            if (!union(edge.from, edge.to, parents)) continue;
            answer += edge.weight;
            cnt++;
            if (cnt == V - 1) return answer;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[E];
        int[] parents = new int[V + 1];
        int A, B, C;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A, B, C);
        }
        Arrays.sort(edges);

        System.out.println(kruskal(V, E, edges, parents));
        br.close();
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
