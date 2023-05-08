import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < caseNum; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input != 0) {
                stack.push(input);
            } else {
                stack.pop();
            }
        }
        int n = stack.size();
        for(int i = 0; i < n; i++) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
