package DP.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B_4779_칸토어집합 {

    static char[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        int n;
        while ((s = br.readLine()) != null) {
            n = Integer.parseInt(s);

            if (n == 0) sb.append("-").append("\n");
            else {
                int size = (int) Math.pow(3, n);
                answer = new char[size];
                for (int i = 0; i < size; i++) answer[i] = '-';
                solution(0, size);
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void solution(int start, int n) {
        if (n == 0) return;
        for (int i = start + n / 3; i < start + n / 3 * 2; i++) {
            answer[i] = ' ';
        }
        solution(start, n / 3);
        solution(start + n / 3 * 2, n / 3);
    }
}
