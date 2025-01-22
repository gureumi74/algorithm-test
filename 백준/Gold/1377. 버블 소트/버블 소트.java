import java.io.*;
import java.util.Arrays;

public class Main {
    static class Num implements Comparable<Num>{
        int value;
        int idx;

        public Num(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Num o) {
            return this.value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Num[] arr = new Num[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Num(Integer.parseInt(br.readLine()), i);
        }
        // 정렬
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i].idx - i, max);
        }

        bw.write(String.valueOf(max + 1));
        bw.close();
    }
}
