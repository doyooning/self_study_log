package BOJ.bronze;

import java.util.Scanner;

public class no_10871 { // X보다 작은 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp<x) {
                System.out.print(temp+" ");
            }
        }

    }
}