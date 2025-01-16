import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(arr);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                long sum = arr[start] + arr[end];
                if(sum == arr[i]) {
                    if(start != i && end != i) {
                        cnt++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                } else if (sum > arr[i]) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
