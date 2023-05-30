import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[], input[];
    static boolean check[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        input = new int[N];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        solution(0, 0);
        System.out.println(sb);
    }
    static void solution(int k, int start) {
        // 중복 없이
        if(k == M) {
            for(int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 N까지의 수가 아니라 수가 주어지기 때문에 방문 배열o
        for(int i = start; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = input[i];
                solution(k + 1, i);
                check[i] = false;
            }
        }
    }
}
