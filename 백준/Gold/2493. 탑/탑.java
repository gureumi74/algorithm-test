import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
    int height;
    int idx;

    public Pair(int height, int idx) {
        this.height = height;
        this.idx = idx;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(100000001, 0));
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (stack.peek().height < height) {
                stack.pop();
            }
            bw.write(stack.peek().idx + " ");
            stack.push(new Pair(height, i));
        }

        bw.close();
    }
}
