package BOJ.silver;

import java.util.Scanner;

// 나의 답안
public class no_1940_1 { // 주몽
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];

        int count = 0;
        int start_index = 0;
        int end_index = 1;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            A[i] = num;
        }

        while (start_index < n-1) {
            if (A[start_index] + A[end_index] == m) {
                count++;
            }
            end_index++;

            if (end_index == n) {
                start_index++;
                end_index = start_index + 1;
            }
        }
        System.out.println(count);
    }
}



