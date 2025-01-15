import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input =  br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        long[] sumArr = new long[n]; // 합배열
        long[] remainArr = new long[m]; // 나눈 나머지들의 개수 카운팅

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);

            if (i == 0) {
                sumArr[i] = arr[i];
            } else {
                sumArr[i] = sumArr[i - 1] + arr[i];
            }
        }

        // 합배열 m 으로 나눈 나머지로 변경, 나머지값 카운팅
        for (int i = 0; i < n; i++) {
            sumArr[i] %= m;
            remainArr[(int) sumArr[i]]++;
        }

        long result = remainArr[0]; // m으로 나누어떨어지는 구간합 개수를 먼저 넣어줌

        for (int i = 0; i < m; i++) {
            // 카운팅 된 나머지값들 중 2개를 고르는 경우의 수 고르기
            if (remainArr[i] > 1) {
                result += remainArr[i] * (remainArr[i] - 1) / 2;
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
