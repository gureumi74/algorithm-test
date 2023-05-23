import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, arr[];
    static boolean[] isused;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        // 0 위치는 버리고 1 ~ n 까지의 방문 여부를 확인하기 위해 +1 증가
        isused = new boolean[n + 1];
        func(0);
        System.out.print(sb);

    }
    public static void func(int k) {
        if(k == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!isused[i]) {
                arr[k] = i;
                isused[i] = true;
                func(k + 1);
                isused[i] = false;
            }
        }
    }
}
