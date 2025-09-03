package BOJ.bronze;

import java.util.Scanner;

public class no_3052 { // 나머지
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] N = new int[42];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            N[a % 42]++;
        }
        for (int i : N) {
            if (i > 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
