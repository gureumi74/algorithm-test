import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        solution(0, 1);
        System.out.println(sb);
    }

    static void solution(int k, int idx) {
        // idx 는 현재 위치를 의미하는 변수
        // 중복되는건 안찾아도 되니까 방문 배열 x
        if (k == m) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= n; i++) {
            arr[k] = i;
            solution(k + 1, i + 1);
        }
    }
}
