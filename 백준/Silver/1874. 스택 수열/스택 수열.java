import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        Stack<Integer> stack = new Stack<>();
        int element = 1;
        boolean check = true;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (element <= num) {
                while (element <= num) {
                    stack.push(element++);
                    sb.append("+\n");
                }
            } else {
                if(stack.peek() != num) {
                    bw.write("NO");
                    check = false;
                    break;
                }
            }

            stack.pop();
            sb.append("-\n");
        }

        if(check) {
            bw.write(sb.toString());
        }

        bw.close();
    }
}
