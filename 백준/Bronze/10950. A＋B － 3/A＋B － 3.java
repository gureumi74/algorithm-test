import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String[] st = br.readLine().split(" ");
            int A = Integer.parseInt(st[0]);
            int B = Integer.parseInt(st[1]);
            System.out.println(A + B);
        }
    }
}