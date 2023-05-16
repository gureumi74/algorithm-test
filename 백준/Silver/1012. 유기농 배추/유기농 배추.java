import java.io.*;
import java.util.*;

public class Main {
    // 유기농 배추
    public int solution(int[][] board) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        boolean[][] visit = new boolean[board.length][board[0].length];
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(visit[i][j] || board[i][j] != 1) continue;
                count++;
                visit[i][j] = true;
                queue.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                while (!queue.isEmpty()) {
                    ArrayList<Integer> cur = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.get(0) + dx[k];
                        int ny = cur.get(1) + dy[k];
                        if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
                        if (visit[nx][ny] || board[nx][ny] != 1) continue;
                        visit[nx][ny] = true;
                        queue.add(new ArrayList<Integer>(Arrays.asList(nx, ny)));
                    }
                }
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        Main result = new Main();

        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] board = new int[M][N];

            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }
            bw.write(result.solution(board) + "\n");
        }
        bw.close();
    }
}
