package Implementation.구현;

import java.io.*;
import java.util.*;

public class Main_B_11382_꼬마정민 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        for (int i = 0; i < 3; i++)
            answer += Long.parseLong(st.nextToken());
        System.out.println(answer);
        br.close();
    }

}
