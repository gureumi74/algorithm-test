import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로 크기
        int m = Integer.parseInt(st.nextToken()); // 가로 크기
        int[][] board = new int[n][m]; // 그림 보드

        // 그림 업데이트
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; // 그림의 개수
        int max = 0; // 가장 큰 그림의 넓이
        int[][] location = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우 하 좌 상

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 1) {
                    cnt++;
                    Queue<Pair> queue = new LinkedList<>();
                    int extent = 1; // 그림 넓이
                    queue.add(new Pair(i, j));
                    board[i][j] = 0;

                    while (!queue.isEmpty()) {
                        Pair cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + location[k][0];
                            int ny = cur.y + location[k][1];
                            if (nx < 0 || ny < 0 || nx >= n | ny >= m) continue;
                            if (board[nx][ny] != 1) continue;
                            board[nx][ny] = 0;
                            queue.add(new Pair(nx, ny));
                            extent++;
                        }
                    }

                    max = Math.max(max, extent);
                }
            }
        }
        
        bw.write(cnt + "\n" + max);
        bw.close();
    }
}
