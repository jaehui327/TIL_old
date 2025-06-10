package DP.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B_17212_달나라토끼 {

    static int[] coins = { 7, 5, 2, 1 };
    static int N, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        solution(0, 0, 0);
        System.out.println(answer);
        br.close();
    }

    public static void solution(int idx, int sum, int cnt) {
        if (idx > coins.length) return;
        if (sum == N) {
            answer = Math.max(answer, sum);
            return;
        }
//        if (sum > N)
    }
}
