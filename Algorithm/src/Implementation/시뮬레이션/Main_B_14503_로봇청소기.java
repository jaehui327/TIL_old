package Implementation.시뮬레이션;

import java.io.*;
import java.util.*;

public class Main_B_14503_로봇청소기 {

    static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

    public static int solution(int N, int M, int r, int c, int d, int[][] map) {
        int answer = 0;
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                answer++;
            }

            boolean hasBlank = false;
            for (int nd = 0; nd < 4; nd++) {
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] > 0) continue;
                hasBlank = true;
                break;
            }

            if (hasBlank) {
                for (int i = 0; i < 4; i++) {
                    d = (d + 3) % 4;
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] > 0) continue;
                    r = nr;
                    c = nc;
                    break;
                }
            } else {
                int nr = r + dr[(d + 2) % 4];
                int nc = c + dc[(d + 2) % 4];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1) break;
                r = nr;
                c = nc;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(N, M, r, c, d, map));
        br.close();
    }

}
