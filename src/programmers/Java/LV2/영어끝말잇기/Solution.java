package LV2.영어끝말잇기;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        // n = 3일 때 1 - 2 - 3 - 1 - 2 - 3 - ...
        // 중복된 단어가 나올 경우, 단어가 한 단어일 경우, 끝말잇기를 못한 경우

        // 결과: 걸린 사람 -> (걸린 위치 i % n) + 1번째 사람
        // 몇 번째 차례에서? -> (걸린 위치 i / n) + 1번째 차례
        //
        String[] checked = new String[words.length];
        String str = words[0];
        checked[0] = str;
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() == 1) { // 단어가 한 단어
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            } else if (!(str.substring(str.length() - 1).equals(words[i].substring(0, 1)))) {
                answer[0] = (i % n) + 1; // 끝말잇기를 못함
                answer[1] = (i / n) + 1;
                break;
            } else {
                for (int j = 1; j < i; j++) { // 단어 중복
                    if (checked[j].equals(str)) {
                        answer[0] = (i % n) + 1;
                        answer[1] = (i / n) + 1;
                        break;
                    }
                }
            }
            str = words[i];
            checked[i] = str;
        }
        for (int i : answer) {
            System.out.println(i);
        }

        return answer;
    }
}
