package DataStructure;

import java.io.*;
import java.util.*;

public class Main_B_7785_회사에있는사람 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            if (status.equals("enter")) set.add(name);
            else set.remove(name);
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, Comparator.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
