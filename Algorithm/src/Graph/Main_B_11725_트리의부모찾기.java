package Graph;

import java.io.*;
import java.util.*;
public class Main_B_11725_트리의부모찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] parents = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (visited[next]) continue;
                parents[next] = cur;
                visited[next] = true;
                queue.offer(next);
            }
        }

        for (int i = 2; i <= N; i++)
            sb.append(parents[i]).append("\n");

        System.out.println(sb);
        br.close();
    }
}
