package DP.dp;

import java.io.*;
import java.util.*;

public class Main_B_7579_앱 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] bytes = new int[N + 1];

        for (int i = 1; i <= N; i++)
            bytes[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] costs = new int[N + 1];
        for (int i = 1; i <= N; i++)
            costs[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[10_001];

        for (int i = 1; i <= N; i++)
            for (int j = 10_000; j > 0; j--)
                if (j >= costs[i]) dp[j] = Math.max(dp[j], dp[j - costs[i]] + bytes[i]);

        int answer = 0;
        while (dp[answer] < M) answer++;

        System.out.println(answer);
        br.close();
    }

}
