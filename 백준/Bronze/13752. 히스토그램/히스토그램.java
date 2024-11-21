import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            bw.write("=".repeat(data) + "\n");
        }

        bw.close();
    }
}