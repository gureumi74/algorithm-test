import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, select[], arr[];
    static boolean[] visited;
    public static void solution(int depth) throws IOException {
        if(depth == m) {
            for(int num: select) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        // 이전 수열의 마지막 항과 새로운 수열의 마지막 항이 같으면 중복 수열
        int tmp = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && tmp != arr[i]) {
                visited[i] = true;
                select[depth] = arr[i];
                tmp = select[depth];
                solution(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        select = new int[m];
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solution(0);
        bw.close();
    }
}
