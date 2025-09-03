package BOJ.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 타인 정답 참고
public class no_1032 { // 명령 프롬프트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n]; // 파일 이름 저장 배열
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine(); // 파일 이름 배열에 저장
        }
        int len = arr[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            boolean b = true; // 모든 파일의 i번째 단어가 같으면 true
            char c = arr[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if(c != arr[j].charAt(i)) {
                    b = false; // 파일의 단어가 다르면 false로 바꿔주기
                }
            }
            if (b) {
                sb.append(c); // 모든 파일의 단어가 같으면 그 단어 출력
            } else {
                sb.append("?"); // 다르면 ? 출력
            }
        }
        System.out.print(sb);
    }
}
