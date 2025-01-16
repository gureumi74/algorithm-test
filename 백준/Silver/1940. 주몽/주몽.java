import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int startIdx = 0;
        int endIdx = n - 1;
        int cnt = 0;
        
        while (startIdx < endIdx) {
            int sum = arr[startIdx] + arr[endIdx];

            if(sum == m) {
                cnt++;
                startIdx++;
                endIdx--;
            } else if (sum > m) {
                endIdx--;
            } else {
                startIdx++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
