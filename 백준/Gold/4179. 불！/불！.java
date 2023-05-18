import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[][] maze;
    static int[][] jihunDist;
    static int[][] fireDist;

    // 지훈이의 큐와 불의 큐를 각각 선언
    static Queue<Pair> jihunQue = new LinkedList<>();
    static Queue<Pair> fireQue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 입출력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        maze = new String[R][C];

        // 지훈이와 불의 이동 횟수를 담은 배열 선언
        jihunDist = new int[R][C];
        fireDist = new int[R][C];

        // 지훈이의 이동 횟수가 불의 이동 횟수보다 같거나, 크면 이동하지 못하게 하도록
        // 불의 이동횟수 전체를 int MAX 값으로 설정
        for(int[] row : fireDist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i = 0; i < R; i++) {
            // 각 시작 지점을 큐에 넣어줌
            String[] s = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                if(s[j].equals("J")) {
                    jihunDist[i][j] = 1;
                    jihunQue.offer(new Pair(i, j));
                }
                else if(s[j].equals("F")) {
                    fireDist[i][j] = 1;
                    fireQue.offer(new Pair(i, j));
                } 
                maze[i][j] = s[j];
            }
        }

        Main result = new Main();
        bw.write(result.BFS());
        bw.close();
    }
    public String BFS() {
        int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!jihunQue.isEmpty()) {
            int fireN = fireQue.size();
            int jihunN = jihunQue.size();

            for(int i = 0; i < fireN; i++) {
                Pair fireCur = fireQue.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = fireCur.x + dist[j][0];
                    int ny = fireCur.y + dist[j][1];
                    if(nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length) continue;
                    if(fireDist[nx][ny] != Integer.MAX_VALUE || maze[nx][ny].equals("#")) continue;
                    fireDist[nx][ny] = fireDist[fireCur.x][fireCur.y] + 1;
                    fireQue.offer(new Pair(nx, ny));
                }
            }

            for(int i = 0; i < jihunN; i++) {
                Pair jihunCur = jihunQue.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = jihunCur.x + dist[j][0];
                    int ny = jihunCur.y + dist[j][1];
                    if(nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length) {
                        return String.valueOf(jihunDist[jihunCur.x][jihunCur.y]);
                    }
                    if(jihunDist[nx][ny] > 0 || fireDist[nx][ny] != Integer.MAX_VALUE || maze[nx][ny].equals("#")) continue;
                    jihunDist[nx][ny] = jihunDist[jihunCur.x][jihunCur.y] + 1;
                    jihunQue.offer(new Pair(nx, ny));

                }

            }
        }
        return "IMPOSSIBLE";
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
