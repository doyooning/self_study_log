package BOJ.bronze;

import java.io.*;
import java.util.StringTokenizer;

// 교재 예제 해설
public class no_15552 { // 빠른 A + B
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader는 br.readLine으로 받음
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // bufferedWriter는 bw.write로 출력
        int n = Integer.parseInt(br.readLine());
        // readLine은 String으로 받음
        // Integer.parseInt 처리까지 해준다
        // + exception 처리까지 필요

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // StringTokenizer는 문자열을 토큰화(분할)하여 받아주는 역할
            int a = Integer.parseInt(st.nextToken());
            // st.nextToken은 st로 받은 문자열을 앞에서부터 하나씩 가져옴
            int b = Integer.parseInt(st.nextToken());
            // System.out.println(a+b); 이것도 오래 걸린다
            // -> BufferedWriter 사용
            bw.write(a+b +"\n");
            // bw.write 후에는 bw.flush로 쌓아둔 결과를 출력
            // 추가로 줄바꿈은 개행 문자를 직접 넣어주어야 함
        }
        bw.flush();
        bw.close();
    }
}
