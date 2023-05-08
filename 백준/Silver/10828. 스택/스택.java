import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int caseNum = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        for(int i = 0; i < caseNum; i++) {
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push")) {
                stack.push(str[1]);
            } else if (str[0].equals("pop")) {
                if(stack.empty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
            } else if (str[0].equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (str[0].equals("empty")) {
                bw.write(stack.empty() ? "1" : "0");
                bw.write("\n");
            } else if (str[0].equals("top")) {
                if (stack.empty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }
        }
        bw.close();
    }
}
