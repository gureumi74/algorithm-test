import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 처음 풀었던 것과 같지만, 이번엔 배열로 주어짐
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
        solution(0);
        System.out.println(sb);
    }
    static void solution(int k) {
        if(k == M) {
            for(int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = input[i];
                solution(k + 1);
                check[i] = false;
            }
        }

    }
}
