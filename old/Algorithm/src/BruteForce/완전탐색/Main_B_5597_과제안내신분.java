package BruteForce.완전탐색;

import java.io.*;

public class Main_B_5597_과제안내신분 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visited = new boolean[31];
        for (int i = 0; i < 28; i++) visited[Integer.parseInt(br.readLine())] = true;
        for (int i = 1; i <= 30; i++) if (!visited[i]) System.out.println(i);
        br.close();
    }

}
