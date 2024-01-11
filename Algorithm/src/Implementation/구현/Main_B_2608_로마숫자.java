package Implementation.구현;

import java.io.*;
import java.util.*;

public class Main_B_2608_로마숫자 {

    static HashSet<String> subChar = new HashSet<>(Arrays.asList("IV", "IX", "XL", "XC", "CD", "CM"));
    static HashMap<String, Integer> romeToDecimal = new HashMap<String, Integer>() {{
       put("I", 1); put("IV", 4); put("V", 5); put("IX", 9); put("X", 10);
       put("XL", 40); put("L", 50); put("XC", 90); put("C", 100);
       put("CD", 400); put("D", 500); put("CM", 900); put("M", 1000);
    }};
    static String[] romes = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    static int[] decimals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = toDecimal(br.readLine()) + toDecimal(br.readLine());
        System.out.println(sum);
        System.out.println(toRome(sum));
        br.close();
    }

    public static int toDecimal(String s) {
        int sum = 0;
        int idx = 0;
        while (idx < s.length()) {
            if (idx + 1 < s.length() && subChar.contains(s.substring(idx, idx + 2))) {
                sum += romeToDecimal.get(s.substring(idx, idx + 2));
                idx += 2;
            } else {
                sum += romeToDecimal.get(s.substring(idx, idx + 1));
                idx++;
            }
        }
        return sum;
    }

    public static String toRome(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            for (int i = 0; i < romes.length; i++) {
                if (n - decimals[i] >= 0) {
                    n -= decimals[i];
                    sb.append(romes[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}