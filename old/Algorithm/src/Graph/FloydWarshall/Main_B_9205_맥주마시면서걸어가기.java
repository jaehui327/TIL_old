package Graph.FloydWarshall;

import java.io.*;
import java.util.*;

public class Main_B_9205_맥주마시면서걸어가기 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Point[] points;
        int[][] distance;

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            points = new Point[N + 2];
            distance = new int[N + 2][N + 2];

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < N + 1; i++)
                for (int j = i + 1; j < N + 2; j++)
                    if (Math.abs(points[i].x - points[j].x) + Math.abs(points[i].y - points[j].y) <= 50 * 20)
                        distance[i][j] = distance[j][i] = 1;
                    else distance[i][j] = distance[j][i] = 987_654_321;

            for (int k = 0; k < N + 2; k++)
                for (int i = 0; i < N + 2; i++)
                    for (int j = 0; j < N + 2; j++)
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);

            if (distance[0][N + 1] > 0 && distance[0][N + 1] < 987_654_321) sb.append("happy\n");
            else sb.append("sad\n");
        }

        System.out.println(sb);
        br.close();
    }
}
