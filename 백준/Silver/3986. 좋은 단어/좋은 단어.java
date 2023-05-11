import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < caseNum; i++) {
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack();
            for(int j = 0; j < input.length; j++) {
                if(!stack.empty() && stack.peek().equals(input[j])) {
                    stack.pop();
                } else {
                    stack.push(input[j]);
                }
            }
            if(stack.empty()) {
               count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}