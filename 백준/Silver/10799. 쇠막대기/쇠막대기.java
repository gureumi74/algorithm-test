import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        char[] input = br.readLine().toCharArray();
        int result = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                stack.add(input[i]);
            } else {
                stack.pop();
                if (input[i - 1] == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
