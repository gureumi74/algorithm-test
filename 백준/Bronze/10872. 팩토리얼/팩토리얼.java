import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n <= 1) {
            bw.write("1");
            bw.close();
        } else {
            long answer = 1;
            for(int i = 2; i <= n; i++) {
                answer *= i;
            }
            bw.write(String.valueOf(answer));
            bw.close();
        }
    }
}
