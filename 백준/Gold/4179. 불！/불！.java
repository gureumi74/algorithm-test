import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(String[][] maze, Queue<Pair> fire, Queue<Pair> jihoon) {
        int[][] location = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int time = 0;

        while (!jihoon.isEmpty()) {
            time++;

            int fireSize = fire.size();

            for (int i = 0; i < fireSize; i++) {
                Pair fireCur = fire.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = fireCur.x + location[j][0];
                    int ny = fireCur.y + location[j][1];
                    if (nx < 0 || ny < 0 || nx >= maze.length || ny >= maze[0].length) continue;
                    if (maze[nx][ny].equals("#") || maze[nx][ny].equals("F")) continue;
                    maze[nx][ny] = "F";
                    fire.add(new Pair(nx, ny));
                }
            }

            int jihoonSize = jihoon.size();

            for(int i = 0; i < jihoonSize; i++) {
                Pair jihoonCur = jihoon.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = jihoonCur.x + location[j][0];
                    int ny = jihoonCur.y + location[j][1];
                    if (nx < 0 || ny < 0 || nx >= maze.length || ny >= maze[0].length) {
                        return time;
                    }

                    if (!maze[nx][ny].equals(".")) continue;
                    maze[nx][ny] = "J";
                    jihoon.add(new Pair(nx, ny));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[][] maze = new String[r][c];
        Queue<Pair> fire = new LinkedList<>();
        Queue<Pair> jihoon = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (input[j].equals("J")) {
                    jihoon.add(new Pair(i, j));
                } else if (input[j].equals("F")) {
                    fire.add(new Pair(i, j));

                }
                maze[i][j] = input[j];
            }
        }

      int time = bfs(maze, fire, jihoon);

        if (time != -1) {
            bw.write(String.valueOf(time));
        } else {
            bw.write("IMPOSSIBLE");
        }

        bw.close();
    }
}
