import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<String> stack = new Stack<>();
            for(String s : input.split("")) {
                if(stack.isEmpty() || !stack.peek().equals(s)) {
                    stack.push(s);
                } else {
                    stack.pop();
                }
            }

            if(stack.isEmpty()) {
                result++;
            }
        }

        System.out.println(result);
    }
}
