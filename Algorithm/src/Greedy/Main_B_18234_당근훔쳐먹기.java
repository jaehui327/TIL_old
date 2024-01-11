package Greedy;

import java.io.*;
import java.util.*;

public class Main_B_18234_당근훔쳐먹기 {

    public static class Carrot implements Comparable<Carrot> {
        long w, p;

        Carrot(long w, long p) {
            this.w = w;
            this.p = p;
        }


        @Override
        public int compareTo(Carrot o) {
            return o.p > this.p ? 1 : -1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int w, p;
        PriorityQueue<Carrot> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            pq.offer(new Carrot(w, p));
        }

        for (int d = T - 1; d >= T - N; d--) {
            Carrot carrot = pq.poll();
            answer += carrot.w + carrot.p * d;
        }

        System.out.println(answer);
        br.close();
    }
}
