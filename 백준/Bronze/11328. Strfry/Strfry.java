import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] c1 = st.nextToken().toCharArray();
            char[] c2 = st.nextToken().toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            String str1 = String.copyValueOf(c1);
            String str2 = String.copyValueOf(c2);
            System.out.println(str1.contains(str2) ? "Possible" : "Impossible");
        }
    }
}
