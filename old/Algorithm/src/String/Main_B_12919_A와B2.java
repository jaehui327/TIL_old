package String;

import java.io.*;
import java.util.*;

public class Main_B_12919_A와B2 {

    static int answer;

    public static void solution(String S, String T) {
        if (S.length() == T.length()) {
            if (S.equals(T)) answer = 1;
            return;
        }

        if (T.charAt(T.length() - 1) == 'A')
            solution(S, T.substring(0, T.length() - 1));
        if (T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(T.substring(1));
            solution(S, sb.reverse().toString());
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        solution(S, T);
        System.out.println(answer);
        br.close();
    }

}
