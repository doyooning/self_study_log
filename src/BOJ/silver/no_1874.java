package BOJ.silver;

import java.util.Scanner;
import java.util.Stack;

// 교재 예제 해설
public class no_1874 { // 스택 수열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        /*연산 방법
        * ex1) 배열에 4 등장
        * -> 스택에 푸시를 4번 해준다(1, 2, 3, 4)
        * -> 팝을 1번만 하면 4가 구해진다
        *
        * ex2) 배열에 3 등장
        * -> 스택에는 1, 2, 3이 차있으니까 팝만 1번 해주면 3 구해짐
        *
        * ex3) 배열에 6 등장
        * -> 스택에 남은 수는 1, 2
        * 4를 이전에 팝을 했으므로 스택에는 5, 6만 푸시
        *
        * */
        Stack<Integer> stack = new Stack<>(); // 스택 선언
        StringBuffer bf = new StringBuffer(); // StringBuffer로 모아서 출력
        int num = 1;
        boolean result = true;
        for (int i = 0; i < A.length; i++) {
            int su = A[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(bf.toString());
        }
    }
}
