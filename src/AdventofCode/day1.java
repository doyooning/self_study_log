package AdventofCode;

import java.io.*;
import java.util.StringTokenizer;

/* https://adventofcode.com/ day1 문제
*  0 ~ 99인 다이얼을 돌려서 100이면 0으로 간주(원형 순환)
*  L000 -> 왼쪽으로 000만큼 돌리기, R000 -> 오른쪽으로 000만큼 돌리기
*  다이얼이 정확히 0에 위치하는 횟수를 세기
* */

public class day1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 50;
        int count = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.startsWith("L")) {
                int i = Integer.parseInt(s.substring(1));
                int cal = n - i;
                if (cal < 0) {
                    cal = 100 - (Math.abs(cal) % 100);
                }
                if ((cal == 0) || (cal == 100)) {
                    count++;
                }
                n = cal;
            }

            if (s.startsWith("R")) {
                int i = Integer.parseInt(s.substring(1));
                int cal = n + i;
                if (cal >= 100) {
                    cal = Math.abs(cal) % 100;
                }
                if ((cal == 0)) {
                    count++;
                }
                n = cal;

            }

            bw.write(count +"\n");
            if (s.equals("end")){
                break;
            }
        }
        bw.flush();
        bw.close();

    }
}
