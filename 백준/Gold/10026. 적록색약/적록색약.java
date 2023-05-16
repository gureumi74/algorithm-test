import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public String solution(String[][] grid) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        boolean[][] visit = new boolean[grid.length][grid.length];
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(visit[i][j]) continue;
                visit[i][j] = true;
                queue.add(new ArrayList<>(Arrays.asList(i, j)));

                count++;
                String s = grid[i][j];
                while (!queue.isEmpty()) {
                    ArrayList<Integer> cur = queue.poll();
                    for(int k = 0; k < 4; k++) {
                        int nx = cur.get(0) + dx[k];
                        int ny = cur.get(1) + dy[k];
                        if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid.length) continue;
                        if(visit[nx][ny] || !grid[nx][ny].equals(s)) continue;
                        visit[nx][ny] = true;
                        queue.add(new ArrayList<Integer>(Arrays.asList(nx, ny)));
                    }
                }
            }
        }

        return String.valueOf(count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(br.readLine());
        String[][] grid = new String[caseNum][caseNum];
        String[][] gridCopy = new String[caseNum][caseNum];
        for(int i = 0; i < caseNum; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < caseNum; j++) {
                grid[i][j] = input[j];
                if(input[j].equals("R")) {
                    gridCopy[i][j] = "G";
                } else {
                    gridCopy[i][j] = input[j];
                }
            }
        }

        Main result = new Main();
        bw.write(result.solution(grid) + " " + result.solution(gridCopy));
        bw.close();
    }
}