import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[10][10];
        int max = 0;
        int maxX = 1;
        int maxY = 1;
        for (int i = 1; i < 10; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j < 10; j++) {
                arr[i][j] = Integer.parseInt(input[j - 1]);
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    maxX = i;
                    maxY = j;
                }
            }
        }

        bw.write(max + "\n");
        bw.write(maxX + " " + maxY);
        bw.close();
    }
}
