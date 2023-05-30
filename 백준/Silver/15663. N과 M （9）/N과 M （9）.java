import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, arr[], input[];
    static boolean[] check;

    // 중복값을 받지 않기 위해 hashset사용
    static LinkedHashSet<String> hs = new LinkedHashSet();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        input = new int[N];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        solution(0);

        for(String s : hs) {
            System.out.println(s);
        }
    }

    static void solution(int k) {
        if (k == M) {
            StringBuilder sb = new StringBuilder();
            for (int val : arr) {
                sb.append(val + " ");
            }
            hs.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = input[i];
                solution(k + 1);
                check[i] = false;
            }

        }
    }
}
