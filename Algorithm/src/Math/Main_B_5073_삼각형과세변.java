package Math;

import java.io.*;
import java.util.*;

public class Main_B_5073_삼각형과세변 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int a, b, c, max;
        while(true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            max = Math.max(a, b);
            c = Integer.parseInt(st.nextToken());
            max = Math.max(max, c);
            if (a == 0 && b == 0 && c == 0) break;

            if (a + b + c - max <= max) { sb.append("Invalid\n"); continue; }

            if (a == b && b == c) sb.append("Equilateral\n");
            else if (a == b || a == c || b == c) sb.append("Isosceles\n");
            else sb.append("Scalene\n");
        }
        System.out.println(sb);
        br.close();
    }
}
