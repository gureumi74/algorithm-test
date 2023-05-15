import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] box) throws IOException {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] dist = new int[box.length][box[0].length];
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < box.length; i++)
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 1) queue.add(new ArrayList<>(Arrays.asList(i, j)));
                else if (box[i][j] == 0) dist[i][j] = -1;
            }

        while (!queue.isEmpty()) {
            ArrayList<Integer> cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.get(0) + dx[k];
                int ny = cur.get(1) + dy[k];
                if (nx < 0 || nx >= box.length || ny < 0 || ny >= box[0].length) continue;
                if (dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cur.get(0)][cur.get(1)] + 1;
                queue.add(new ArrayList<Integer>(Arrays.asList(nx, ny)));
            }
        }

        int answer = 0;
        for(int i = 0; i < box.length; i++) {
            for(int j = 0; j < box[i].length; j++) {
                if(dist[i][j] == -1) {
                    return -1;
                }
                if(answer < dist[i][j]) answer = dist[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main result = new Main();
        bw.write(String.valueOf(result.solution(arr)));
        bw.close();
    }
}
