package DataStructure;

import java.io.*;
import java.util.*;

public class Main_B_1655_가운데를말해요 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (max.size() == min.size()) {
                max.offer(n);
                if (!min.isEmpty() && max.peek() > min.peek()) {
                    min.add(max.poll());
                    max.add(min.poll());
                }
            } else {
                min.offer(n);
                if (max.peek() > min.peek()) {
                    min.add(max.poll());
                    max.add(min.poll());
                }
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

}
