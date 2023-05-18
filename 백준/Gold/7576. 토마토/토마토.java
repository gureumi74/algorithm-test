import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public int solution(int[][] box) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 방문 목록이 아니라, 퍼지는데 얼마나 걸리는지 구하기 위한 dist 선언
        int[][] dist = new int[box.length][box[0].length];
        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 1) queue.offer(new Pair(i, j));
                else if (box[i][j] == 0) dist[i][j] = -1;
            }
        }

          while (!queue.isEmpty()) {
                Pair cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || nx >= box.length || ny < 0 || ny >= box[0].length) continue;
                    if (dist[nx][ny] >= 0) continue;
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    queue.offer(new Pair(nx, ny));
                }
            }

        int answer = 0;
        for(int i = 0; i < box.length; i++) {
            for(int j = 0; j < box[0].length; j++) {
                if(dist[i][j] == -1) return -1;
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
        int[][] box = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main result = new Main();
        bw.write(String.valueOf(result.solution(box)));
        bw.close();
                 
    }
    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}