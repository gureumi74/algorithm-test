import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        solution(0);
        System.out.println(sb);

    }
    static void solution(int k) {
        // 준복 가능하니까 방문배열 필요없고, 전부 다 출력하면 됨 
        if(k == M) {
            for(int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            arr[k] = i;
            solution(k + 1);

        }
    }
}
