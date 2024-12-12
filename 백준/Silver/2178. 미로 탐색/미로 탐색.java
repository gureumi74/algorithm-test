import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

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
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] board = new int[n][m];
        int[][] maze = new int[n][m]; // BFS 이용해서 최단 경로 담을 배열
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        int[][] location = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        queue.add(new Pair(0, 0));
        board[0][0] = 0;
        // 자기 칸 포함 계산
        maze[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + location[i][0];
                int ny = cur.y + location[i][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] != 1) continue;
                board[nx][ny] = 0;
                maze[nx][ny] = maze[cur.x][cur.y] + 1;
                queue.add(new Pair(nx, ny));
            }
        }

        bw.write(String.valueOf(maze[n - 1][m - 1]));
        bw.close();
    }
}
