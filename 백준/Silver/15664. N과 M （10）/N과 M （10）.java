import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, select[], arr[];
    public static void solution(int depth, int idx) throws IOException {
        if (depth == m) {
            for (int num: select) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        int tmp = 0;
        for(int i = idx; i < n; i++) {
            if(tmp != arr[i]) {
                select[depth] = arr[i];
                tmp = select[depth];
                solution(depth + 1, i + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        select = new int[m];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solution(0, 0);
        bw.close();
    }
}