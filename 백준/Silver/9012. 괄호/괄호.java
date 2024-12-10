import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<String> stack = new Stack<>();
            boolean check = true;
            for (String s : input.split("")) {
                if(s.equals("(")) {
                    stack.push("(");
                } else if (stack.isEmpty()) {
                    check = false;
                    break;
                } else {
                    stack.pop();
                }
            }

            if(check && stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.close();
    }
}
