import java.awt.*;
import java.io.*;

public class Main {
    static int blue, white, paper[][];
    public static boolean check(int x, int y, int size) {
        int n = paper[x][y];
        for(int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != n) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void solution(int x, int y, int size) {
        if(check(x, y, size)) {
           if (paper[x][y] == 0) white++;
           if (paper[x][y] == 1) blue++;
           return;
        }

        int newSize = size / 2;

        for (int i = x; i < x + size; i += newSize) {
            for (int j = y; j < y + size; j += newSize) {
                solution(i, j, newSize);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        String[] input;
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }
        solution(0, 0, n);
        bw.write(white + "\n");
        bw.write(blue + "\n");
        bw.close();
    }
}
