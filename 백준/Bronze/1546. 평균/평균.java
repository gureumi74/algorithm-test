import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int max = 0;
        double sum = 0;
        for(int i = 0; i < N; i++) {
            int score = Integer.parseInt(input[i]);
            max = Math.max(max, score);
            sum += score;
        }

        bw.write(String.valueOf(sum * 100 / max / N));
        bw.close();
    }
}
