import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좌표를 담기위한 Pair 선언
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] note, sticker;
    static int N, M, K, stickerN, stickerM, count, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로의 길이
        M = Integer.parseInt(st.nextToken()); // 가로의 길이
        K = Integer.parseInt(st.nextToken()); // 스티커의 개수
        note = new int[N][M];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stickerN = Integer.parseInt(st.nextToken()); // 스티커의 세로 길이
            stickerM = Integer.parseInt(st.nextToken()); // 스티커의 가로 길이
            sticker = new int[stickerN][stickerM];
            // 입력받은 스티커 정보 배열에 저장
            count = 0;
            for(int j = 0; j < sticker.length; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < sticker[0].length; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                    if(sticker[j][k] == 1) count++;
                }
            }
            noteCheck();
            result += count;
        }

        System.out.println(result);
    }

    static void noteCheck() {
        for(int k = 0; k < 4; k++) {
            for(int i = 0; i <= N - sticker.length; i++) {
                for(int j = 0; j <= M - sticker[0].length; j++) {
                    if(sticking(new Pair(i, j))) return;
                }
            }
            rotation90();
        }

        count = 0;
    }
    static boolean sticking(Pair start) {
        for(int i = 0; i < sticker.length; i++) {
            for(int j = 0; j < sticker[0].length; j++) {
                if(sticker[i][j] == 1 && note[i + start.x][j + start.y] == 1) return false;
            }
        }

        for(int i = 0; i < sticker.length; i++) {
            for(int j = 0; j < sticker[0].length; j++) {
                if(sticker[i][j] == 1) {
                    note[i + start.x][j + start.y] = 1;
                }
            }
        }

        return true;
    }
    static void rotation90() {
        int[][] tmp = new int[sticker.length][sticker[0].length];
        for(int i = 0; i < sticker.length; i++) {
            System.arraycopy(sticker[i], 0, tmp[i], 0, sticker[0].length);
        }
        sticker = new int[tmp[0].length][tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            for(int j = 0; j < tmp[0].length; j++) {
                if(tmp[i][j] == 1) {
                    sticker[j][tmp.length - 1 - i] = 1;
                }
            }
        }
    }
}

