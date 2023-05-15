import java.io.*;
import java.util.*;

public class Main {
    public void solution(int[][] board) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visit = new boolean[board.length][board[0].length];
        int[][] moveCount = new int[board.length][board[0].length];
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(0, 0)));
        visit[0][0] = true;
        moveCount[0][0] = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.get(0) + dx[i];
                int ny = cur.get(1) + dy[i];
                if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
                if(visit[nx][ny] || board[nx][ny] != 1) continue;
                visit[nx][ny] = true;
                moveCount[nx][ny] = moveCount[cur.get(0)][cur.get(1)] + 1;
                queue.add(new ArrayList<Integer>(Arrays.asList(nx, ny)));
            }
        }
        bw.write(String.valueOf(moveCount[board.length - 1][board[0].length - 1]));
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        Main baekjoon2178 = new Main();
        baekjoon2178.solution(arr);
    }
}
