import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();
        int caseNum = Integer.parseInt(br.readLine());

        int idx = 0;
        boolean noCheck = false;
        for(int i = 0; i < caseNum; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input > idx) {
                for(int j = idx + 1; j < input + 1; j++) {
                    stack.push(j);
                    result.add("+");
                }
                idx = input;
            } else if (stack.peek() != input) {
                noCheck = true;
                break;
            }

            stack.pop();
            result.add("-");
        }

        if (noCheck) {
            System.out.println("NO");
        } else {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }
}
