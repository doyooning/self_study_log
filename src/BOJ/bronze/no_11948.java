package BOJ.bronze;

import java.util.Scanner;

// 교재 예제 해설
public class no_11948 { // 과목선택
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int min_a = Integer.MAX_VALUE; // 충분히 큰 값을 임의로 설정
        int min_b = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) { // 4과목 중 3과목 선택
            int temp = sc.nextInt();
            sum += temp;
            if (temp < min_a) { // 이 조건은 맨 처음에 무조건 실행됨
                min_a = temp;   // 때문에 min_a에는 최초에 temp로 받은 값이 들어감
            } // for문을 끝내면 min_a에는 최소값이 저장되어 있음
        }
        for (int i = 0; i < 2; i++) { // 2과목 중 1과목 선택
            int temp = sc.nextInt();
            sum += temp;
            if (temp < min_b) {
                min_b = temp;
            }
        }
        System.out.println(sum - min_a - min_b);
    }
}
