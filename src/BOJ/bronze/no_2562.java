package BOJ.bronze;

import java.util.Scanner;

public class no_2562 { // 최댓값
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int temp = 0;

        for (int i = 1; i < 10; i++) {
            int a = sc.nextInt();
            if (a > temp) {
                temp = a;
                x = i;
            }
        }
        System.out.println(temp);
        System.out.println(x);
    }
}
