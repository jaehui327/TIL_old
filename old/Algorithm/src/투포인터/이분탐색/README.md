# 이분 탐색 Binary search

이분 탐색이란 정렬된 리스트에서 원하는 값(target)의 존재 위치를 찾는 알고리즘입니다.<br>
반드시 리스트를 정렬해서 사용해야 하며, 탐색할 때 마다 검사 범위가 절반으로 줄어듭니다.<br>
시간 복잡도는 최대 O(logN)을 보장합니다. <br>


```
💡 이분 탐색 알고리즘 구현 방법
1. 시작 인덱스(low)와 끝 인덱스(high)를 지정 후, 
사이 값에서 중간 값(mid)을 선택하여 찾고자 하는 값과 같은지 확인합니다.
2. 찾고자 하는 값(target)이라면 해당 값을 반환합니다.
3. 찾고자 하는 값보다 작다면(mid < target), 검사 범위를 큰 쪽으로 이동시키기 위해 low = mid + 1을 합니다.
4. 찾고자 하는 값보다 크다면(mid > target), 검사 범위를 작은 쪽으로 이동시키기 위해 high = mid - 1을 합니다.
5. 더 이상 검사할 곳이 없을 때 까지(low < high)위 과정을 반복합니다.
```

## 코드
[백준 3079번 입국심사](https://www.acmicpc.net/problem/3079)
```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long min = 0;
        long[] immigration = new long[N];
        for (int i = 0; i < N; i++)
            immigration[i] = Long.parseLong(br.readLine());
        Arrays.sort(immigration);

        long low = 1;
        long high = M * immigration[N - 1];
        long mid, sum;

        while(low <= high) {
            mid = (low + high) / 2;
            sum = 0;
            for (int i = 0; i < N; i++) {
                sum += mid / immigration[i];
                if (sum > M) break;
            }

            if (sum >= M)
                high = mid - 1;
            else
                low = mid + 1;
        }

        System.out.println(low);
        br.close();
    }
}
```