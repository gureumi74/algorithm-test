import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String[][] board;
    public static void solution(int x, int y, int size) {
        if(size == 1) {
            board[x][y] = "*";
            return;
        }

        int newSize = size / 3;
        int cnt = 0;
        for (int i = x; i < x + size; i += newSize) {
            for (int j = y; j < y + size; j += newSize) {
                if (cnt == 4) {
                    cnt++;
                    continue;
                }
                solution(i, j, newSize);
                cnt++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        board = new String[n][n];
        solution(0, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == null) {
                    sb.append(" ");
                } else {
                    sb.append(board[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
