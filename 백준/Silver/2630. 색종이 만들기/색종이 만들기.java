import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 아멘.....
    static int N, map[][], white = 0, blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0, 0, N);
        bw.write(white + "\n");
        bw.write(blue + "\n");
        bw.close();
    }
    static void solution(int r, int c, int size) {
        if(check(r, c, size)) {
            if(map[r][c] == 0) white++;
            if(map[r][c] == 1) blue++;
            return;
        }

        int newSize = size / 2;
        for(int i = r; i < r + size; i += newSize) {
            for(int j = c; j < c + size; j += newSize) {
                solution(i, j, newSize);
            }
        }
    }
    static boolean check(int r, int c, int size) {
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(map[r][c] != map[i][j]) return false;
            }
        }

        return true;
    }
}
