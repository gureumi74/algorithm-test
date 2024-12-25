import java.io.*;

public class Main {
    static int n, m;
    static int[] select;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void solution(int depth, int idx) throws IOException {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                bw.write(select[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = idx; i <= n; i++) {
            select[depth] = i;
            solution(depth + 1, i + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        select = new int[m];
        visited = new boolean[n];
        solution(0, 1);
        bw.close();
    }
}
