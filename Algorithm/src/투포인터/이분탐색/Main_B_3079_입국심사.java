package 투포인터.이분탐색;

import java.io.*;
import java.util.*;

public class Main_B_3079_입국심사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long min = 0;
        long[] immigration = new long[N];
        for (int i = 0; i < N; i++)
            immigration[i] = Long.parseLong(br.readLine());
        Arrays.sort(immigration);

        long low = 1;
        long high = M * immigration[N - 1];
        long mid, sum;

        while(low <= high) {
            mid = (low + high) / 2;
            sum = 0;
            for (int i = 0; i < N; i++) {
                sum += mid / immigration[i];
                if (sum > M) break;
            }

            if (sum >= M)
                high = mid - 1;
            else
                low = mid + 1;
        }

        System.out.println(low);
        br.close();
    }
}
