# 재귀

### [백준 28069번 김밥천국의 계단](https://www.acmicpc.net/problem/28069)

[풀이 블로그 참조](https://zhiblog.tistory.com/46)

```java
import java.io.*;
import java.util.*;

public class Main {

    static int N, K;

    static int solution(int i, int cnt) {
        if (i < 3) return cnt + i;
        if (i % 3 == 0) return solution(i / 3 * 2, cnt + 1);
        else if ((i - 1) % 3 == 0) return solution((i - 1) / 3 * 2 + 1, cnt + 1);
        else return solution(i - 1, cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int min = solution(N, 0);
        if (min <= K) System.out.println("minigimbob");
        else System.out.println("water");
        br.close();
    }
}
```