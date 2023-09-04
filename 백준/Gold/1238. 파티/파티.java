import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // n명의 학생
        int M = Integer.parseInt(st.nextToken()); // m개의 단방향 도로
        int X = Integer.parseInt(st.nextToken()); // 파티를 벌이는 마을

        ArrayList<int[]>[] list = new ArrayList[N + 1]; // 인접 리스트
        ArrayList<int[]>[] reverseList = new ArrayList[N + 1]; // 역방향 리스트

        // 값 초기화
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        // 정보 담기
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            // 도착 부분과 시간을 넣어줌
            list[start].add(new int[]{end, time});
            // 반대도 넣어줌
            reverseList[end].add(new int[]{start, time});
        }

       // 파티하는 곳부터 각 정점까지의 최단 거리 구하기
       int[] dist = dijkstra(X, N, list);
        int[] reverseDist = dijkstra(X, N, reverseList);

        // 양방향으로 최단 거리 구하기, 더 긴 거리 찾아내기
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dist[i] + reverseDist[i]);
        }

        System.out.println(result);

    }

    // 다익스트라 알고리즘
    static int[] dijkstra(int n, int N, ArrayList<int[]>[] list) {
        int[] dist = new int[N + 1];
        // 초기값 설정
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 가장 작은 거리를 가져오도록 설정 (오름차순)
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        // 시작하는 부분은 거리 0으로 우선순위 큐에 추가
        queue.add(new int[]{n, 0});

        while (!queue.isEmpty()) {
            // 우선순위 큐에서 가장 작은 거리의 노드를 가져온다.
            int[] cur = queue.poll();

            if(dist[cur[0]] < cur[1]) {
                continue; // 이미 처리된 노드 무시
            }

            // 현재 노드까지의 최단 거리 업데이트
            dist[cur[0]] = cur[1];

            for(int[] arr : list[cur[0]]) {
                queue.add(new int[]{arr[0], cur[1] + arr[1]});
                // 현재 노드를 통해 갈 수 있는 노드를 우선순위 큐에 저장
            }
        }

        return dist; // 모든 노드까지의 최단 거리 배열 반환
    }
}
