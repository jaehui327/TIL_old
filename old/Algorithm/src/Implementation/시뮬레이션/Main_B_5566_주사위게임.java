package Implementation.시뮬레이션;

import java.io.*;
import java.util.*;

public class Main_B_5566_주사위게임 {

    static int game(int N, int M, int[] map, int[] dice) {
        int cnt = 0;
        int idx = 1;
        for (int i = 1; i <= M; i++) {
            cnt++;
            idx += dice[i];
            if (idx >= N) break;
            idx += map[idx];
            if (idx >= N) break;
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] map = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        int[] dice = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            dice[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(game(N, M, map, dice));
        br.close();
    }
}
