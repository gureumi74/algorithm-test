import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] stats;
    static int[] start, link;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stats = new int[n][n];
        visit = new boolean[n];
        start = new int[n / 2];
        link = new int[n / 2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        team(0, 1);
        System.out.println(min);
    }

    static void team(int k, int num) {
        if(k == n / 2) {
            int check = 0;
            for(int i = 1; i <= n; i++) {
                if(Arrays.binarySearch(start, i) < 0){
                    link[check] = i;
                    check++;
                };
            }
//            System.out.println("start = " + Arrays.toString(start));
//            System.out.println("link = " + Arrays.toString(link));
            teamScore();
            return;
        }

        for(int i = num; i <= n; i++) {
            if(!visit[i - 1]) {
                start[k] = i;
                visit[i - 1] = true;
                team(k + 1, i);
                visit[i - 1] = false;
            }
        }
    }
    static void teamScore() {
        int startScore = 0;
        int linkScore = 0;

        for(int i = 0; i < n / 2 - 1; i++) {
            for(int j = i; j < n / 2; j++) {
                startScore += stats[start[i] - 1][start[j] - 1];
                startScore += stats[start[j] - 1][start[i] - 1];
                linkScore += stats[link[i] - 1][link[j] - 1];
                linkScore += stats[link[j] - 1][link[i] - 1];
            }
        }

        min = Math.min(Math.abs(startScore - linkScore), min);
        if (min == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }

}
