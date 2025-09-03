package LV1.택배상자꺼내기;

public class Solution {
    public int solution(int n, int w, int num) {
        // 박스의 총 개수 : n
        // 한 행에 놓을 박스의 개수 : w
        // 꺼내야 할 박스의 번호 : num

        // 인덱스 유의

        int answer = 0;
        int height = n / w; // <꽉 찬> 박스 층수
        int top = n % w; // 꽉 채우고 남은 박스 개수
        int numh = ((num-1) / w) + 1; // 해당 num이 위치한 실제 층수

        int numwr = (w * numh) - num; // 해당 num이 위치한 행번호값(역순)
        int numw = ((num-1) % w) + 1; // 해당 num이 위치한 행번호값(정순)

        int[][] N = new int[height+2][w+1];

        // 2차원 배열 생성(꽉 찬 상자)
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= w ; j++) {
                N[i][j]++;
            }
        }

        // 꽉 찬 박스 높이가 짝수층이면 바로 위층은 정순으로
        if ((height % 2) == 0) {
            for (int i = 1; i <= top; i++) {
                N[height+1][i]++;
            }
        }

        // 꽉 찬 박스 높이가 홀수층이면 바로 위층은 역순으로
        if ((height % 2) == 1) {
            for (int i = (w - top) + 1; i <= w; i++) {
                N[height+1][i]++;
            }
        }

        // num이 위치한 층수가 짝수층이면 numwr 적용
        if (numh % 2 == 0) {
            for (int i = numh; i <= height + 1; i++) {
                if (N[i][numwr] == 1) {
                    answer++;
                }
            }
        }

        // num이 위치한 층수가 홀수층이면 numw 적용
        if (numh % 2 == 1) {
            for (int i = numh; i <= height + 1; i++) {
                if (N[i][numw] == 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
