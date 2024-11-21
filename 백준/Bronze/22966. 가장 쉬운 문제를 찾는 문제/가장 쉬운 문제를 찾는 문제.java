import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int easyLevel = 5;
        String easyQuestion = "";

        for(int i = 0; i < n; i++) {
            String[] question = br.readLine().split(" ");
            int level = Integer.parseInt(question[1]);
            if(easyLevel > level) {
                easyLevel = level;
                easyQuestion = question[0];
            }
        }

        bw.write(easyQuestion);
        bw.close();
    }
}
