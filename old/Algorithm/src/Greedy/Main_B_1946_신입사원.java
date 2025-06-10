package Greedy;

import java.io.*;
import java.util.*;
public class Main_B_1946_신입사원 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map.put(a, b);
            }
            sb.append(cntNewRecruit(N, map)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static int cntNewRecruit(int N, HashMap<Integer, Integer> map) {
        int result = 1;
        int high = map.get(1);

        for (int i = 2; i <= N; i++) {
            if (map.get(i) > high) continue;
            result++;
            high = map.get(i);
        }

        return result;
    }

}
