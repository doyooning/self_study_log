package AdventofCode;

import java.io.*;
import java.util.StringTokenizer;

public class day2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken(",");

            long a = Long.parseLong(st.nextToken().split("-")[0]);
            long b = Long.parseLong(st.nextToken().split("-")[1]);

            /* 나올 수 있는 숫자 길이
            * 2, 4, 6, 8, 10
            * 00-0000000 이런 식으로 주어질 때
            * 따져봐야 할 경우 :
            * 1) 2자리 0=0
            * 2) 4자리 00=00
            * 3) 6자리 000=000
            * (자릿수 / 2) 길이의 숫자에서 경우를 따져본다 ex) 길이 6 -> 203203
            *
            * */


            if (s.equals("e")){
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
