import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치
        if (n == k) {
            System.out.println(0);
            return;
        }
        int[] board = new int[100001];
        board[k] = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int[] location = {-1, 1, 2};

        while (board[k] == -1) {
            int cur = queue.poll();
            for(int i = 0; i < location.length; i++) {
                int nx = 0;
                if (i == location.length - 1) {
                    nx = cur * location[i];
                } else {
                    nx = cur + location[i];
                }

                if (nx < 0 || nx >= board.length || board[nx] > 0) continue;
                queue.add(nx);
                board[nx] = board[cur] + 1;
            }
        }

        bw.write(String.valueOf(board[k]));
        bw.close();
    }
}
