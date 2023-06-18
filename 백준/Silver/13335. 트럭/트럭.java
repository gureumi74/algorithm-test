import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, w, L;
    static ArrayList<Integer> truck = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 트럭의 개수
        w = Integer.parseInt(st.nextToken()); // 다리의 길이 (단위길이)
        L = Integer.parseInt(st.nextToken()); // 다리의 최대하중
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(solution());
    }
    static int solution() {
        Queue<Integer> que = new LinkedList<>(); // 다리를 건너는 큐
        ArrayList<Integer> end = new ArrayList<>(); // 도착한 트럭의 리스트
        int sum = 0; // 다리를 건너는 트럭의 무게가 최대하중을 넘지않도록 sum 변수 선언
        int count = 0; // 다리를 하나씩 건널 때마다 count 증가
        // 다리 큐에 다리길이만큼 0을 넣어줌
        for(int i = 0; i < w; i++) {
            que.add(0);
        }
        while (true) {
            // 우선 맨 처음에 있는 큐 값을 빼고
            int poll = que.poll();
            // 큐가 0이 아니면 sum 에서 빼주고, end에 트럭이 도착했다는 표시로 추가해줌
            if(poll != 0) {
                sum -= poll;
                end.add(poll);
            }

            // 아직 출발안한 트럭이 1대라도 있고 출발하려는 트럭이 최대하중에 맞게 이동할 수 있다면
            if(truck.size() != 0 && sum + truck.get(0) <= L) {
                // 트럭정보를 빼고
                int tmp = truck.get(0);
                // 출발안한 트럭 정보에서 트럭 빼기
                truck.remove(0);
                // 큐에 값을 넣고
                que.add(tmp);
                // 다리 무게에 추가해줌
                sum += tmp;
            } else {
                // 아니면 0을 큐에 넣어줌
                que.add(0);
            }
            // 이 행동이 끝날때마다 카운트 증가
            count++;
            // 만약 도착한 트럭의 개수가 총 트럭 개수랑 같다면 break
           if(end.size() == n) break;
        }

        return count;
    }
}
