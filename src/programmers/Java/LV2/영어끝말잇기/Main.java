package LV2.영어끝말잇기;

public class Main {
    static Solution sol = new Solution();
    public static void main(String[] args) {
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println(sol.solution(5, words));
    }
}