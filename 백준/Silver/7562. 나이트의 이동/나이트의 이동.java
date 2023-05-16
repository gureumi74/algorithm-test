import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public int solution(int[][] board, int startX, int startY) {
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<Integer>(Arrays.asList(startX, startY)));
        int[][] moveCount = new int[board.length][board.length];
        boolean[][] visit = new boolean[board.length][board.length];
        visit[startX][startY] = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> cur = queue.poll();
            for(int i = 0; i < 8; i++) {
                int nx = cur.get(0) + dx[i];
                int ny = cur.get(1) + dy[i];
                if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) continue;
                if(visit[nx][ny]) continue;
                if(board[nx][ny] == -1) {
                    return moveCount[cur.get(0)][cur.get(1)] + 1;
                }
                queue.add(new ArrayList<Integer>(Arrays.asList(nx, ny)));
                moveCount[nx][ny] = moveCount[cur.get(0)][cur.get(1)] + 1;
                visit[nx][ny] = true;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(br.readLine());

        Main result = new Main();

        for(int i = 0; i < caseNum; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] board = new int[size][size];
            String[] startInput = br.readLine().split(" ");
            String[] endInput = br.readLine().split(" ");
            int startX = Integer.parseInt(startInput[0]);
            int startY = Integer.parseInt(startInput[1]);
            int endX = Integer.parseInt(endInput[0]);
            int endY = Integer.parseInt(endInput[1]);

            board[startX][startY] = 1;
            board[endX][endY] = -1;

            bw.write(result.solution(board, startX, startY) + "\n");
        }

        bw.close();
    }
}
