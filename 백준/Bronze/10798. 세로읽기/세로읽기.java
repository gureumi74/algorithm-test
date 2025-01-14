import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] arr = new String[15][5];
        int idx = 15;

        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < input.length; j++) {
                arr[j][i] = input[j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != null) {
                    bw.write(arr[i][j]);
                }
            }
        }

        bw.close();
    }
}
