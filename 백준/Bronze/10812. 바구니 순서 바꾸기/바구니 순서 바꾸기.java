import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bucketNum = Integer.parseInt(st.nextToken());
        int caseNum = Integer.parseInt(st.nextToken());

        int[] bucket = new int[bucketNum];
        for(int i = 1; i <= bucketNum; i++) {
            bucket[i - 1] = i;
        }

        for(int i = 0; i < caseNum; i++) {
            int[] copy = Arrays.copyOf(bucket, bucketNum);
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int mid = Integer.parseInt(st.nextToken()) - 1;
            int idx = 0;
            for(int j = 0; j < start; j++) {
                copy[idx++] = bucket[j];
            }
            for(int j = mid; j <= end; j++) {
                copy[idx++] = bucket[j];
            }
            for(int j = start; j < mid; j++) {
                copy[idx++] = bucket[j];
            }
            bucket = Arrays.copyOf(copy, bucketNum);
        }
        for(int i : bucket) {
            bw.write(i + " ");
        }
        bw.close();
    }
}
