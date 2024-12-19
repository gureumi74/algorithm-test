import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Coordinate {
        int h;
        int x;
        int y;

        public Coordinate(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }

    static boolean zeroCheck(int[][][] tomato, int h, int n, int m) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomato[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomato = new int[h][n][m];
        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) {
                        queue.add(new Coordinate(i, j, k));
                    }
                    tomato[i][j][k] = input;

                }
            }
        }


        int[][] location = {{1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {0, -1, 0}};
        int day = 0;

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();

            for (int i = 0; i < location.length; i++) {
                int nh = cur.h + location[i][0];
                int nx = cur.x + location[i][1];
                int ny = cur.y + location[i][2];

                if (nh < 0 || nx < 0 || ny < 0 || nh >= h || nx >= n || ny >= m) continue;
                if (tomato[nh][nx][ny] == -1 || tomato[nh][nx][ny] > 0) continue;
                tomato[nh][nx][ny] = tomato[cur.h][cur.x][cur.y] + 1;
                queue.add(new Coordinate(nh, nx, ny));
                day = tomato[nh][nx][ny];
            }
        }

        if (zeroCheck(tomato, h, n, m)) {
            bw.write(day == 0 ? String.valueOf(day) : String.valueOf(day - 1));
        } else {
            bw.write(String.valueOf(-1));
        }

        bw.close();
    }
}
