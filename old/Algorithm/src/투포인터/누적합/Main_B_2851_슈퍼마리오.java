package 투포인터.누적합;

import java.io.*;

public class Main_B_2851_슈퍼마리오 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] prefixSum = new int[10];
        prefixSum[0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < 10; i++) prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(br.readLine());

        int result = 0;
        for (int num : prefixSum) {
            if (Math.abs(100 - result) < Math.abs(100 - num)) continue;
            result = num;
        }

        System.out.println(result);
        br.close();
    }
}
