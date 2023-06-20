import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int r, c, d, count;
    static int[][] room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 방 가로크기
        M = Integer.parseInt(st.nextToken()); // 방 세로크기
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // x 좌표
        c = Integer.parseInt(st.nextToken()); // y 좌표
        d = Integer.parseInt(st.nextToken()); // 방향(0 : 위, 1 : 오른쪽, 2 : 아래, 3 : 왼쪽)
        room = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        System.out.println(count);
    }
    static void solution() {
        int[][] dist = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (true) {
            boolean check = false;
            if(room[r][c] == 0) {
               room[r][c] = 2;
               count++;
            } else {
                for(int i = d - 1; i > d - 5; i--) {
                    int nx = r + dist[(i + 4) % 4][0];
                    int ny = c + dist[(i + 4) % 4][1];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(room[nx][ny] > 0) continue;
                    check = true;
                    r = nx;
                    c = ny;
                    d = (i + 4) % 4;
                    break;
                }
                if(!check) {
                    r += dist[(d + 2) % 4][0];
                    c += dist[(d + 2) % 4][1];
                    if(r < 0 || r >= N || c < 0 || c >= M || room[r][c] == 1) break;
                }
            }
        }
    }
}
