import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 쿼드 트리
public class Main {
    static int board[][], n;
    static StringBuilder sb = new StringBuilder();
    public static boolean check(int x, int y, int size) {
        int num = board[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void solution(int x, int y, int size) {
        if (check(x, y, size)) {
            sb.append(board[x][y]);
            return;
        }

        sb.append("(");
        int newSize = size / 2;
        for (int i = x; i < x + size; i += newSize) {
            for (int j = y; j < y + size; j += newSize) {
                solution(i, j, newSize);
            }
        }
        sb.append(")");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        solution(0, 0, n);
        System.out.println(sb.toString());
    }
}
