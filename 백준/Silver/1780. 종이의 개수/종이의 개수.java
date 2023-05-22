import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, map[][], minus = 0, zero = 0, one = 0;
    static boolean check(int r, int c, int size) {
        // 전체 색종이가 전부 같은 글자인지 체크하는 함수
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                // 현재 위치의 값과 쪼개진 맵들이 같은 값이 아니면 실패 반환
                if(map[r][c] != map[i][j]) return false;
            }
        }
        return true;
    }
    static void solution(int r, int c, int size) {
        if(check(r, c, size)) {
            //  전부 같은 글자이면 각 부분을 +1 해줌
            if(map[r][c] == 0) zero++;
            if(map[r][c] == 1) one++;
            if(map[r][c] == -1) minus++;
            return;
        }

        // 전부 같은 글자가 아니라면 9등분을 해서 재귀
        int newSize = size / 3;
        for(int i = r; i < r + size; i+= newSize) {
            for(int j = c; j < c + size; j+= newSize) {
                solution(i, j, newSize);
            }
        }
    }
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
        bw.write(minus + "\n");
        bw.write(zero + "\n");
        bw.write(one + "\n");
        bw.close();

    }
}
