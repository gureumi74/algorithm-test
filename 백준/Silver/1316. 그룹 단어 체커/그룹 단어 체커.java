import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean solution(String input) {
        boolean[] alpCheck = new boolean[26];
        alpCheck[input.charAt(0) - 'a'] = true;
        for (int i = 1; i < input.length(); i++) {
            int n = input.charAt(i) - 'a';
            if (input.charAt(i - 1) - 'a' == n) {
                continue;
            }

            if (alpCheck[n]) {
                return false;
            } else {
                alpCheck[n] = true;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if (solution(input)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
