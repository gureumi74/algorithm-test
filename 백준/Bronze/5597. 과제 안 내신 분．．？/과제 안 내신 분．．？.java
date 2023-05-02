import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] attendanceStudent = new int[30];
        for(int i = 0; i < 28; i++) {
            attendanceStudent[Integer.parseInt(br.readLine()) - 1] = 1;
        }
        for(int i = 1; i <= 30; i++) {
            if (attendanceStudent[i - 1] == 0) {
                bw.write(String.valueOf(i) + "\n");
            }
        }

        bw.close();
    }
}
