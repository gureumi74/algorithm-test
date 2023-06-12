import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 뿌요뿌요
    static String bord[][] = new String[12][6];
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static Queue<Pair> que = new LinkedList<>(); // BFS를 하기 위한 큐
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 12; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < 6; j++) {
                bord[i][j] = input[j];
            }
        }
        while (true) {
            if(BFS()) {
                count++;
                fall();
            }
            else break;
        }

        System.out.println(count);
    }

    static boolean BFS() {
        // 방문배열
        boolean[][] visit = new boolean[12][6];
        boolean check = false;

        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 6; j++) {
                if(visit[i][j] || bord[i][j].equals(".")) continue;
                Queue<Pair> countQue = new LinkedList<>(); // 4개 이상일 경우 해당 좌표를 . 로 바꾸기 위해 선언
                que.offer(new Pair(i, j));
                countQue.offer(new Pair(i, j));
                visit[i][j] = true;
                String tmp = bord[i][j];

                while (!que.isEmpty()) {
                    Pair cur = que.poll();
                    for(int k = 0; k < 4; k++) {
                        int nx = cur.x + dist[k][0];
                        int ny = cur.y + dist[k][1];
                        if(nx < 0 || nx >= bord.length || ny < 0 || ny >= bord[0].length) continue;
                        if(visit[nx][ny] || !bord[nx][ny].equals(tmp)) continue;
                        visit[nx][ny] = true;
                        que.add(new Pair(nx, ny));
                        countQue.add(new Pair(nx, ny));
                    }
                }

                if(countQue.size() > 3) {
                    check = true;
                    int size = countQue.size();
                    for(int k = 0; k < size; k++) {
                        Pair cur = countQue.poll();
                        bord[cur.x][cur.y] = ".";
                    }
                }

            }
        }
        return check;

    }
    static void fall() {
        for(int j = 0; j < 6; j++) {
            for(int i = 11; i > 0; i--) {
                if(!bord[i][j].equals(".")) continue;
                int l = 1;
                while (l != i && bord[i - l][j].equals(".")) l++;

                bord[i][j] = bord[i - l][j];
                bord[i - l][j] = ".";
            }
        }
    }
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

