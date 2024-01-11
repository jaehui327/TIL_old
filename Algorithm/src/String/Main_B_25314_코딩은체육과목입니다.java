package String;

import java.io.*;

public class Main_B_25314_코딩은체육과목입니다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()) - 1;
        for (int i = 0; i < N / 4; i++) {
            sb.append("long ");
        }
        sb.append("long int");
        System.out.println(sb.toString());
        br.close();
    }
}
