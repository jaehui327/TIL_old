package Math;

import java.io.*;

public class Main_B_2292_벌집 {

    static long solution(long n, long cnt, long N) {
        if (n >= N) return cnt;
        return solution(n + 6 * cnt, cnt + 1, N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        System.out.println(solution(1, 1, N));
        br.close();
    }
}
