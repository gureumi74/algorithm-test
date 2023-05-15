import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public void BFSSolution(int[][] board) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visit = new boolean[board.length][board[0].length];
        int max = 0; // 그림의 최댓값
        int num = 0; // 그림의 개수

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 || visit[i][j]) continue;
                num++;
                Queue<ArrayList<Integer>> queue = new LinkedList<>();
                visit[i][j] = true;
                queue.add(new ArrayList<>(Arrays.asList(i, j)));

                int area = 0;
                while (!queue.isEmpty()) {
                    area++;
                    ArrayList<Integer> cur = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.get(0) + dx[k];
                        int ny = cur.get(1) + dy[k];
                        if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
                        if (visit[nx][ny] || board[nx][ny] != 1) continue;
                        visit[nx][ny] = true;
                        queue.add(new ArrayList<>(Arrays.asList(nx, ny)));
                    }
                }
                if (max < area) max = area;
            }
        }
        bw.write(num + "\n" + max);
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];
        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main baekjoon1926 = new Main();
        baekjoon1926.BFSSolution(arr);
    }
}
