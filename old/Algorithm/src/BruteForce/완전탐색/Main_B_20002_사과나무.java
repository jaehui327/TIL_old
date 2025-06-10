package BruteForce.완전탐색;

import java.io.*;
import java.util.*;

public class Main_B_20002_사과나무 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] sum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int max = -1001;
        for (int size = 0; size < N; size++) {
            for (int i = 1; i <= N - size; i++) {
                for (int j = 1; j <= N - size; j++) {
                    max = Math.max(max, sum[i + size][j + size] - sum[i - 1][j + size] - sum[i + size][j - 1] + sum[i - 1][j - 1]);
                }
            }
        }
        System.out.println(max);
        br.close();
    }

}
