package String;

import java.io.*;

public class Main_B_9086_문자열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            sb.append(s.substring(0, 1)).append(s.substring(s.length() - 1)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
