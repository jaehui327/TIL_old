package Implementation.구현;

import java.io.*;
import java.util.*;

public class Main_B_17281_야구 {

    static int N, max;
    static int[] order;
    static boolean[] selected;
    static int[][] players;

    static void permutation(int r) {
        if (r == 9) {
            baseball(0, 0, 0, 0, false, false, false);
            return;
        }
        if (r == 3) {
            order[3] = 0;
            permutation(r + 1);
            return;
        }
        for (int i = 1; i < 9; i++) {
            if (selected[i]) continue;
            order[r] = i;
            selected[i] = true;
            permutation(r + 1);
            selected[i] = false;
        }
    }

    static void baseball(int inning, int score, int out, int order_idx, boolean base1, boolean base2, boolean base3) {
        if (inning == N) {
            max = Math.max(max, score);
            return;
        }
        if (out == 3) {
            baseball(inning + 1, score, 0, order_idx, false, false, false);
            return;
        }

        if (order_idx == 9) order_idx = 0;
        switch (players[inning][order[order_idx]]) {
            case 0:
                baseball(inning, score, out + 1, order_idx + 1, base1, base2, base3);
                break;
            case 1:
                if (base3) { score++; base3 = false; }
                if (base2) { base2 = false; base3 = true; }
                if (base1) base2 = true;
                baseball(inning, score, out, order_idx + 1, true, base2, base3);
                break;
            case 2:
                if (base3) { score++; base3 = false; }
                if (base2) score++;
                if (base1) base3 = true;
                baseball(inning, score, out, order_idx + 1, false, true, base3);
                break;
            case 3:
                if (base3) score++;
                if (base2) score++;
                if (base1) score++;
                baseball(inning, score, out, order_idx + 1, false, false, true);
                break;
            case 4:
                if (base3) score++;
                if (base2) score++;
                if (base1) score++;
                baseball(inning, score + 1, out, order_idx + 1, false, false, false);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        players = new int[N][9];
        order = new int[9];
        selected = new boolean[9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++)
                players[i][j] = Integer.parseInt(st.nextToken());
        }
        permutation(0);
        System.out.println(max);
        br.close();
    }
}
