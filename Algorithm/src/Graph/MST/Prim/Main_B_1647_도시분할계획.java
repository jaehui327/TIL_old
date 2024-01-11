package Graph.MST.Prim;

import java.io.*;
import java.util.*;

public class Main_B_1647_도시분할계획 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;



        br.close();
    }
}
