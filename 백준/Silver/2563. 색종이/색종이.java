import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[100][100];
        int result = 0;
        for (int t = 0; t < n; t++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    if (arr[i][j]) {
                        continue;
                    }
                    arr[i][j] = true;
                    result++;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
