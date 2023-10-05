# Kruskal Algorithm

간선 중심으로 최소 신장 트리를 구하는 알고리즘으로, 간선이 적을 때 유리합니다.<br>
```
💡 크루스칼 알고리즘 구현 방법
1. 간선들을 가중치의 오름차순으로 정렬합니다.
2. 가중치가 가장 작은 간선을 선택하여 그 간선이 지금까지 만들어진 MST와 사이클을 형성한다면 제외하고, 아니면 MST에 추가합니다.
3. 모든 간선에 대해 반복합니다.
```

### 구현 코드
[백준 1197번 최소 스패닝 트리](https://www.acmicpc.net/problem/1197)

```java
import java.io.*;
import java.util.*;

public class Main {


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
```