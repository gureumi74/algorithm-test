import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                queue.add(i);
                answer++;
                while (!queue.isEmpty()) {
                    int idx = queue.poll();
                    for(int j = 0; j < n; j++) {
                        if(j == idx || visited[j]) continue;
                        if(computers[idx][j] == 0) continue;
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }
        return answer;
    }
}