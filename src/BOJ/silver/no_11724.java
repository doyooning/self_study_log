package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 교재 예제 해설
/* 연결 요소 = 그래프에서 서로 연결된 노드의 세트
* 노드 = 데이터, 에지 = 연결선
* */
public class no_11724 { // 연결 요소의 개수
    static boolean[] visited; // 방문 기록 저장 배열
    static ArrayList<Integer>[] A; // 그래프 데이터(ArrayList)를 담을 배열
    public static void main(String[] args) throws IOException {
        // BufferedReader와 StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드의 개수
        int m = Integer.parseInt(st.nextToken()); // 에지의 개수
        visited = new boolean[n + 1]; // 0 제외하고 1 ~ n까지의 T/F칸 사용
        A = new ArrayList[n + 1]; // ArrayList도 칸 1 ~ n개 만들어줌
        for (int i = 1; i < n + 1; i++) { // for문은 1부터 n까지 (0 포함 x)
            A[i] = new ArrayList<Integer>(); // ArrayList 초기화
        }
        for (int i = 0; i < m; i++) { // s, e : 에지 꼭짓점
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e); // 양쪽에 서로 에지 더해줌
            A[e].add(s); // 양쪽에 서로 에지 더해줌
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if(!visited[i]) { // 방문하지 않은 노드가 없을 때까지 반복
                count++; // 방문 안한 노드가 있다 -> 새로 탐색 시작 = 연결 요소 +1
                DFS(i); // 방문 안한 노드가 있으면 DFS 진행
            }
        }
        System.out.println(count);
    }

    private static void DFS(int v) {
        if (visited[v]) { // 마지막 for문에서 방문 안한 노드 없으면 여기서 끝남
            return; // 재귀 함수 탈출
        }
        visited[v] = true;
        for (int i : A[v]) {
            if(!visited[i]) { // 배열 A의 v번째 요소(ArrayList) 내부를 돌면서 방문 여부 탐색
                DFS(i); // 재귀, 방문 안한 노드 있으면 다시 DFS
            }
        }
    }
}
