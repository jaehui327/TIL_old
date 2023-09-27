# 투포인터

## 코드
[백준 2467번 용액](https://www.acmicpc.net/problem/2467)

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)  arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        long min = Long.MAX_VALUE;
        long sum;
        long[] answer = new long[2];
        while (left < right) {
            sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                min = Math.abs(sum);
            }
            if (sum < 0) left++;
            else right--;
        }

        System.out.println(answer[0] + " " + answer[1]);
        br.close();
    }
}
```

---

# 이분 탐색
