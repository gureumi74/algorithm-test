import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void func(int a, int b, int n) throws IOException {
        // a기둥은 시작 기둥, b기둥은 도착 기둥
        if(n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }
        func(a, 6 - a - b, n - 1);
        bw.write(a + " " + b + "\n");
        func(6 - a - b, b, n - 1);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        bw.write(((1 << k) - 1) + "\n");
        func(1, 3, k);
        bw.close();

    }
}
