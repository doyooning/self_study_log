package BOJ.silver;

import java.util.Scanner;

// 교재 예제 해설
public class no_1929 { // 소수 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] A = new int[N+1]; // 배열은 인덱스, 0~N까지(=N+1개)

        // 초기 배열 설정(2~N까지)
        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        // 2부터 N의 제곱근까지
        for (int i = 2; i <= Math.sqrt(N); i++) {
            // 배열 안의 요소가 배수이면 건너뜀
            if (A[i] == 0) {
                continue;
            }
            // 소수의 배수 값을 N까지 반복, 0으로 표시
            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            }
        }

        // 걸러내고 남은 배열을 결과값으로 표시
        for (int i = M; i <= N; i++) {

            // 0이 아닌 값은 소수값
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
