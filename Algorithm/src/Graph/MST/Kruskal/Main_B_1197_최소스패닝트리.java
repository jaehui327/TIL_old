package Graph.MST;

import java.io.*;
import java.util.*;

public class Main_B_1197_최소스패닝트리 {

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {

        }
        br.close();
    }
}
