import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numCount = new int[10];
        int multiNum = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        while (multiNum > 0) {
            numCount[multiNum % 10]++;
            multiNum /= 10;
        }
        for(int i = 0; i < 10; i++) {
            bw.write(numCount[i] + "\n");
        }
        bw.close();
    }
}