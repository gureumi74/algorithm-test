import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m, select[];
    public static void solution(int depth) throws IOException {
        if(depth == m) {
            for(int num: select) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            select[depth] = i + 1;
            solution(depth + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        select = new int[m];
        solution(0);
        bw.close();
    }
}
