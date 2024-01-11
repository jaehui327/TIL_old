package Implementation.시뮬레이션;

import java.io.*;
import java.util.*;

public class Main_왕실의기사대결 {

    static class PushRobot {
        int r, c, h, w, k, attack;

        PushRobot(int r, int c, int h, int w, int k, int attack) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
            this.attack = attack;
        }
    }

    static int L, N, Q;
    static int[][] map;
    static PushRobot[] pushRobots;
    static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 }; // 0: 위 1: 오른쪽 2: 아래쪽 3: 왼쪽
    static List<Integer> movePushRobots;

    static void move(int n, int d) {
        movePushRobots = new ArrayList<>();

        if (pushRobots[n].attack == pushRobots[n].k) return;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(n);
        visited[n] = true;

        boolean canMove = true;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            int r = pushRobots[cur].r;
            int c = pushRobots[cur].c;
            int h = pushRobots[cur].h;
            int w = pushRobots[cur].w;

            r += dr[d];
            c += dc[d];

            if (r <= 0 || r + h - 1 > L || c <= 0 || c + w - 1 > L) {
                canMove = false;
                break;
            }

            if (d == 0 && hasWallInRow(r, c, w)) { // 위
                canMove = false;
                break;
            } else if (d == 1 && hasWallInColumn(r, c + w - 1, h)) { // 오른쪽
                canMove = false;
                break;
            } else if (d == 2 && hasWallInRow(r + h - 1, c, w)) { // 아래쪽
                canMove = false;
                break;
            } else if (d == 3 && hasWallInColumn(r, c, h)) { // 왼쪽
                canMove = false;
                break;
            }

            for (int i = 1; i <= N; i++) {
                if (pushRobots[i].attack == pushRobots[i].k) continue;
                if (visited[i]) continue;

                int nr = pushRobots[i].r;
                int nc = pushRobots[i].c;
                int nh = pushRobots[i].h;
                int nw = pushRobots[i].w;

                if (d == 0 && hasPushRobotInRow(r, c, w, nr, nc, nh, nw)) { // 위
                    queue.offer(i);
                    visited[i] = true;
                    movePushRobots.add(i);
                } else if (d == 1 && hasPushRobotInColumn(r, c + w - 1, h, nr, nc, nh, nw)) { // 오른쪽
                    queue.offer(i);
                    visited[i] = true;
                    movePushRobots.add(i);
                } else if (d == 2 && hasPushRobotInRow(r + h - 1, c, w, nr, nc, nh, nw)) { // 아래쪽
                    queue.offer(i);
                    visited[i] = true;
                    movePushRobots.add(i);
                } else if (d == 3 && hasPushRobotInColumn(r, c, h, nr, nc, nh, nw)) { // 왼쪽
                    queue.offer(i);
                    visited[i] = true;
                    movePushRobots.add(i);
                }
            }
        }

        if (!canMove) {
            movePushRobots = new ArrayList<>();
            return;
        }

        pushRobots[n].r += dr[d];
        pushRobots[n].c += dc[d];
        for (int i = 0; i < movePushRobots.size(); i++) {
            int nn = movePushRobots.get(i);
            pushRobots[nn].r += dr[d];
            pushRobots[nn].c += dc[d];
        }
    }

    static boolean hasWallInRow(int r, int c, int w) {
        for (int nc = c; nc < c + w; nc++) {
            if (map[r][nc] == 2)
                return true;
        }
        return false;
    }

    static boolean hasWallInColumn(int r, int c, int h) {
        for (int nr = r; nr < r + h; nr++) {
            if (map[nr][c] == 2)
                return true;
        }
        return false;
    }

    static boolean hasPushRobotInRow(int r, int c, int w, int pr, int pc, int ph, int pw) {
        for (int nc = c; nc < c + w; nc++) {
            if (pr <= r && r <= pr + ph - 1 && pc <= nc && nc <= pc + pw - 1)
                return true;
        }
        return false;
    }

    static boolean hasPushRobotInColumn(int r, int c, int h, int pr, int pc, int ph, int pw) {
        for (int nr = r; nr < r + h; nr++) {
            if (pr <= nr && nr <= pr + ph - 1 && pc <= c && c <= pc + pw - 1)
                return true;
        }
        return false;
    }

    static void doAttack() {
        for (int i = 0; i < movePushRobots.size(); i++) {
            int n = movePushRobots.get(i);
            if (pushRobots[n].attack == pushRobots[n].k) continue;

            for (int r = pushRobots[n].r; r < pushRobots[n].r + pushRobots[n].h; r++) {
                if (pushRobots[n].attack == pushRobots[n].k) break;
                for (int c = pushRobots[n].c; c < pushRobots[n].c + pushRobots[n].w; c++) {
                    if (pushRobots[n].attack == pushRobots[n].k) break;
                    if (map[r][c] == 1) {
                        pushRobots[n].attack++;
                    }
                }
            }
        }
    }

    static int getAnaswer() {
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (pushRobots[i].attack == pushRobots[i].k) continue;
            answer += pushRobots[i].attack;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[L + 1][L + 1];
        for (int r = 1; r <= L; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= L; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        pushRobots = new PushRobot[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            pushRobots[i] = new PushRobot(r, c, h, w, k, 0);
        }

        for (int q = 1; q <= Q; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            move(i, d); // 1) 이동
            doAttack(); // 2) 공격
        }

        System.out.println(getAnaswer());
        br.close();
    }
}
