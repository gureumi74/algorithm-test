import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 부분수열의 합
    static int n, count, arr[], s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        func(0, 0);
        // s가 0이면 공집합 하나가 들어감, 크기가 양수인 부분수열 이라는 조건 때문에 공집합 하나를 빼줌
        if(s == 0) System.out.println(count - 1);
        else System.out.println(count);

    }
    static void func(int k, int sum) {
        if(k == n) {
            if(sum == s) count++;
            return;
        }

        func(k + 1, sum); // 다음 숫자를 더하지 않는 경우
        func(k + 1, sum + arr[k]); // 다음 숫자를 더하는 경우

    }
}
