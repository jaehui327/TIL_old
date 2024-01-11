package Implementation.구현;

import java.io.*;
import java.util.*;

public class Main_B_17136_색종이붙이기 {

    static int[][] map;
    static int answer;
    static int[] square = { 0, 5, 5, 5, 5, 5 };


    static void solution(int r, int c, int cnt) {
        if (r == 9 && c == 10) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (answer <= cnt) return;
        if (c == 10) { solution(r + 1, 0, cnt); return; }

        if (map[r][c] == 1) {
            for (int size = 5; size > 0; size--) {
                if (square[size] > 0 && check(r, c, size)) {
                    visited(r, c, size, 0);
                    square[size]--;
                    solution(r, c + 1, cnt + 1);
                    visited(r, c, size, 1);
                    square[size]++;
                }
            }
        } else solution(r, c + 1, cnt);
    }

    static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) return false;
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void visited(int r, int c, int size, int value) {
        for (int i = r; i < r + size; i++)
            for (int j = c; j < c + size; j++)
                map[i][j] = value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[10][10];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0, 0);
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
        br.close();
    }

}
