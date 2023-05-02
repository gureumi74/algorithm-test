import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] bucket = IntStream.rangeClosed(1, N).toArray();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            changeArr(bucket, start, end);
        }

        for(int i = 0; i < bucket.length; i++) {
            bw.write(String.format("%d ", bucket[i]));
        }
        bw.close();

    }
    public static int[] changeArr(int[] bucket, int start, int end) {
        if (start == end) {
            return bucket;
        }
        int i = 0;
        do {
            int tmp = bucket[start + i];
            bucket[start + i] = bucket[end - i];
            bucket[end - i] = tmp;
            i++;
        } while (i <= (end - start) / 2);

        return bucket;
    }
}
