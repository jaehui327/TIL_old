package BruteForce.완전탐색;

import java.io.*;
import java.util.*;

public class Main_B_7490_0만들기 {

    static StringBuilder answer;

    public static void isZero(int i, int num, int sign, int sum, int N, String s) {
        if (i == N) {
            sum = sum + (sign * num);
            if (sum == 0)
                answer.append(s).append("\n");
            return;
        }
        isZero(i + 1, num * 10 + (i + 1), sign, sum, N, s + " " + (i + 1));
        isZero(i + 1, i + 1, 1, sum + (sign * num), N, s + "+" + (i + 1));
        isZero(i + 1, i + 1, -1, sum + (sign * num), N, s + "-" + (i + 1));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            isZero(1, 1, 1, 0, N, "1");
            answer.append("\n");
        }

        System.out.println(answer);
        br.close();
    }
}
