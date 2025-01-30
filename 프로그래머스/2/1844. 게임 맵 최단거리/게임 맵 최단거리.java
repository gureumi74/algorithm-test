import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<Pair> queue = new LinkedList<>();

        int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + move[i][0];
                int ny = cur.y + move[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] != 1) continue;
                queue.add(new Pair(nx, ny));
                maps[nx][ny] = maps[cur.x][cur.y] + 1;
            }
        }

        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}