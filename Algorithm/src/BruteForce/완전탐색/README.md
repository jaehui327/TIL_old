# 완전탐색

## 슬라이딩 윈도우

### [백준 2531번 회전초밥](https://www.acmicpc.net/problem/2531)

[풀이 블로그 참조](https://zhiblog.tistory.com/45)

```java
import java.io.*;
import java.util.*;

public class Main {

    static int solution(int N, int d, int k, int c, int[] sushi) {
        int cnt = 1;
        int[] selected = new int[d + 1];
        selected[c]++;
        for (int i = 0; i < k; i++) {
            if (selected[sushi[i]] == 0) cnt++;
            selected[sushi[i]]++;
            sushi[N + i] = sushi[i];
        }

        int answer = cnt;

        for (int i = 0; i < N; i++) {
            selected[sushi[i]]--;
            if (selected[sushi[i]] == 0) cnt--;
            if (selected[sushi[i + k]] == 0) cnt++;
            selected[sushi[i + k]]++;

            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N + k];
        for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());

        System.out.println(solution(N, d, k, c, sushi));
        br.close();
    }
}
```