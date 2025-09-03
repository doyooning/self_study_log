package LV2.점찍기;

public class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long limit = d / k; // a, b의 최대 인덱스 값

        for (long a = 0; a <= limit; a++) {
            // b^2 <= (d/k)^2 - a^2
            long maxB = (long) Math.sqrt((long) limit * limit - a * a);
            answer += (maxB + 1); // a의 각각의 경우마다 찍을 수 있는 점의 최대 개수는 최대 b + 1개
        }
        return answer;
    }
}
// 이중 for문 = 시간 초과(long)

// a^2 + b^2 <= (d/k)^2
// b^2 <= (d/k)^2 - a^2 --->> b <= sqrt((d/k)^2 - a^2)
// a, b가 가질 수 있는 값은 0 ~ d / k까지