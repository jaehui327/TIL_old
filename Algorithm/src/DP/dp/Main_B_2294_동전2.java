package DP.dp;

import java.io.*;
import java.util.*;

public class Main_B_2294_동전2 {
    static int N, K, answer;
    static ArrayList<Integer> coins;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new ArrayList<>();
        for (int i = 0; i < N; i++) coins.add(Integer.parseInt(br.readLine()));
        Collections.sort(coins, Comparator.reverseOrder());

        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) solution(i, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    public static void solution(int idx, int sum, int cnt) {
        if (idx == N) return;
        if (cnt >= answer) return;

        if (sum == K) {
            answer = Math.min(answer, cnt);
            return;
        }
        if (sum + coins.get(idx) > K) solution(idx + 1, sum, cnt);
        else solution(idx, sum + coins.get(idx), cnt + 1);
    }
}
