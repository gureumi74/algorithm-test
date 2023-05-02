import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList();
        for(int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine()) % 42;
            if(!list.contains(n)) {
                list.add(n);
            }
        }
        bw.write(String.valueOf(list.size()));
        bw.close();
    }
}
