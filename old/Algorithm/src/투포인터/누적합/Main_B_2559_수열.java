package 투포인터.누적합;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B_2559_수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        prefixSum[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            int sum = prefixSum[i] - prefixSum[i - K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
        br.close();
    }

}
