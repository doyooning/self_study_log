package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 교재 예제 해설
public class no_1940 { // 주몽
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 재료의 개수
        int M = Integer.parseInt(bf.readLine()); // 갑옷을 만드는 데 필요한 수
        int[] A = new int[N]; // 재료 배열
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // StringTokenizer 사용, BufferedReader 통해서 입력값을 받음
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // 토큰 단위로 배열에 추가
        }
        Arrays.sort(A); // 배열 오름차순 정렬
        // 투 포인터 구현(처음, 끝)
        int count = 0;
        int i = 0; // 시작 인덱스 : 0
        int j = N-1; // 끝 인덱스 : N-1(배열 끝)
        while (i < j) { // 포인터가 서로 만날 때까지 반복
            if (A[i] + A[j] < M) {
                i++;
            } else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        bf.close();
    }
}

