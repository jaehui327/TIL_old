package Greedy;

import java.util.*;
import java.io.*;

public class Main_B_1202_보석도둑 {

    static class Jewel implements Comparable<Jewel> {
        int weight, value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight == 0 ? o.value - this.value : this.weight - o.weight; // 무게: 오름차순, 같은 경우 가격 내림차순
        }
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("res/1202.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, value);
        }
        Arrays.sort(jewels);

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) bags[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bags); // 가방 무게 오름차순

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 가격 내림차순
        long answer = 0;
        for (int i = 0, idx = 0; i < K; i++) { // 가방 무게가 작은 순서로 탐색
            while(idx < N && jewels[idx].weight <= bags[i])
                pq.offer(jewels[idx++].value);

            if (!pq.isEmpty())
                answer += pq.poll();
        }

        System.out.println(answer);
        br.close();
    }

}
