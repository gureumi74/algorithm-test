import java.io.*;
import java.nio.Buffer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split("");
        Stack<String> stack = new Stack();
        int count = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i].equals("(")) {
                stack.push(input[i]);
            } else {
                if(input[i - 1].equals("(")) {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
