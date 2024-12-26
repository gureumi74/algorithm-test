import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int bfs() throws IOException {
        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        String[][] building = new String[h][w];
        Queue<Pair> person = new LinkedList<>(); // 상근 bfs
        Queue<Pair> fire = new LinkedList<>(); // 불 bfs
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < h; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                if (input[j].equals("@")) {
                    person.add(new Pair(i, j));
                } else if (input[j].equals("*")) {
                    fire.add(new Pair(i, j));
                }

                building[i][j] = input[j];
            }
        }

        int time = 0;
        while (!person.isEmpty() || !fire.isEmpty()) {
            int fireSize = fire.size();
            time++;

            for (int k = 0; k < fireSize; k++) {
                Pair cur = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + move[i][0];
                    int ny = cur.y + move[i][1];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (building[nx][ny].equals("*") || building[nx][ny].equals("#")) continue;
                    building[nx][ny] = "*";
                    fire.add(new Pair(nx, ny));
                }
            }

            int personSize = person.size();

            for(int k = 0; k < personSize; k++) {
                Pair cur = person.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + move[i][0];
                    int ny = cur.y + move[i][1];
                    if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        return time;
                    }
                    if(!building[nx][ny].equals(".")) continue;
                    building[nx][ny] = "@";
                    person.add(new Pair(nx, ny));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        int testCaseNum = Integer.parseInt(br.readLine());

        for(int t = 0; t < testCaseNum; t++) {
            int time = bfs();
            bw.write(time == -1 ? "IMPOSSIBLE\n" : time + "\n");
        }

        bw.close();
    }
}
