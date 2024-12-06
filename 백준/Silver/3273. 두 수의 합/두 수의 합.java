import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numCnt = new int[2000000];
        int x = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < x && numCnt[x - num] == 1) {
                result++;
            }
            numCnt[num] = 1;
        }

        System.out.println(result);
    }
}
