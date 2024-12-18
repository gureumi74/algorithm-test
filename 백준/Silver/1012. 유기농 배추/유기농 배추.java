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
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken()); // 배추 위치 개수

            int[][] farm = new int[m][n];
            int[][] location = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int result = 0;

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                farm[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (farm[i][j] == 1) {
                        result++;
                        Queue<Pair> queue = new LinkedList<>();
                        queue.add(new Pair(i, j));
                        farm[i][j] = 0;

                        while (!queue.isEmpty()) {
                            Pair cur = queue.poll();

                            for (int l = 0; l < 4; l++) {
                                int nx = cur.x + location[l][0];
                                int ny = cur.y + location[l][1];
                                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                                if (farm[nx][ny] == 0) continue;
                                queue.add(new Pair(nx, ny));
                                farm[nx][ny] = 0;
                            }
                        }

                    }
                }
            }

            bw.write(String.valueOf(result + "\n"));
        }
        bw.close();
    }
}
