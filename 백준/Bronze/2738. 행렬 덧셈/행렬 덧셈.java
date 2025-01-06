import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] arr = new int[n][m];

        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                input = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    arr[j][k] += Integer.parseInt(input[k]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.close();
    }
}
