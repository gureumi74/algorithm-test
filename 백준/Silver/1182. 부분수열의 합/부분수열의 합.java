import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int cnt = 0;
    public static int n, s;
    public static int[] arr;
    public static void solution(int cur, int total) {
        if(cur == n) {
            if (total == s) {
                cnt++;
            }
            return;
        }

        solution(cur + 1, total);
        solution(cur + 1, total + arr[cur]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        arr = new int[n];
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        solution(0, 0);
        System.out.println(s == 0 ? cnt - 1 : cnt);
    }
}
