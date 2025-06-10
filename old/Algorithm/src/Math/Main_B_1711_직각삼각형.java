package Math;

import java.io.*;
import java.util.*;

public class Main_B_1711_직각삼각형 {

    static int N, answer;
    static int[] selected;
    static long[][] points;

    public static void combination(int r, int idx) {
        if (r == 3) {
            isRightTriangle(points[selected[0]], points[selected[1]], points[selected[2]]);
            return;
        }

        for (int i = idx; i < N; i++) {
            selected[r] = i;
            combination(r + 1, i + 1);
        }
    }

    public static void isRightTriangle(long[] a, long[] b, long[] c) {
        long ab = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        long ac = (a[0] - c[0]) * (a[0] - c[0]) + (a[1] - c[1]) * (a[1] - c[1]);
        long bc = (c[0] - b[0]) * (c[0] - b[0]) + (c[1] - b[1]) * (c[1] - b[1]);

        if ((ab == ac + bc) || (ac == ab + bc) || (bc == ab + ac)) answer++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        points = new long[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Long.parseLong(st.nextToken());
            points[i][1] = Long.parseLong(st.nextToken());
        }

        answer = 0;
        selected = new int[3];

        combination(0, 0);
        System.out.println(answer);
        br.close();
    }

}
