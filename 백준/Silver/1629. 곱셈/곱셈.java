import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long pow(int A, int B, int C) {
        if(B == 1) return A % C;
        long val = pow(A, B/2, C);
        val = val * val % C;
        if(B % 2 == 0) return val;
        return val * A % C;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(pow(A, B, C)));
        bw.close();


    }
}
