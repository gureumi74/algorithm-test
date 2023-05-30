import java.io.*;
import java.util.*;

public class Main {
    static int[][] office, copyOffice, coordinate = new int[8][2];
    static int count, total, location, arr[], cctvCase[] = new int[8], max;
    static int[][] dist = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // 행
        int y = Integer.parseInt(st.nextToken()); // 열
        office = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] == 0) total++;
                else if(office[i][j] != 6) {
                    cctvCase[location] = office[i][j];
                    coordinate[location++] = new int[]{i, j};
                }
            }
        }

        arr = new int[location];
        solution(0);
        System.out.println(total - max);

    }

    static void solution(int k) {
        if(k == location) {
            count = 0;


            // 원본 카피
            copyOffice = new int[office.length][];
            for(int i = 0; i < office.length; i++) {
                copyOffice[i] = Arrays.copyOf(office[i], office[i].length);
            }


            for(int i = 0; i < location; i++) {
                // 기준점
                int dx = coordinate[i][0];
                int dy = coordinate[i][1];

                // 이동 좌표
                int nx = dist[arr[i] - 1][0];
                int ny = dist[arr[i] - 1][1];

                if(cctvCase[i] > 0) move(dx, dy, nx, ny);
                if(cctvCase[i] > 1) {
                    if(cctvCase[i] == 2) {
                        nx = dist[(arr[i] + 1) % 4][0];
                        ny = dist[(arr[i] + 1) % 4][1];
                    } else {
                        nx = dist[arr[i] % 4][0];
                        ny = dist[arr[i] % 4][1];
                    }
                    move(dx, dy, nx, ny);
                }

                if(cctvCase[i] > 3) {
                    nx = dist[(arr[i] + 1) % 4][0];
                    ny = dist[(arr[i] + 1) % 4][1];
                    move(dx, dy, nx, ny);
                }

                if(cctvCase[i] > 4) {
                    nx = dist[(arr[i] + 2) % 4][0];
                    ny = dist[(arr[i] + 2) % 4][1];
                    move(dx, dy, nx, ny);
                }
            }

            if(max < count) {
                max = count;
            }

            return;
        }

        for(int i = 1; i <= 4; i++) {
            if(cctvCase[k] == 2 && i > 2) continue;
            if(cctvCase[k] == 5 && i > 1) continue;
            arr[k] = i;
            solution(k + 1);
        }
    }

    static void move(int dx, int dy, int nx, int ny) {
        while (true) {
            dx += nx;
            dy += ny;
            if(dx < 0 || dx >= office.length || dy < 0 || dy >= office[0].length) break;
            if(office[dx][dy] == 6) break;
            if(copyOffice[dx][dy] != 0) continue;
            copyOffice[dx][dy] = 7;
            count++;
        }
    }

}

