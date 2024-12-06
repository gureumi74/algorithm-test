import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int element = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > element) {
                for(int j = element + 1; j <= num; j++) {
                    stack.push(j);
                    list.add("+");
                }
                element = num;
            } else {
                if (stack.peek() != num) {
                    list.clear();
                    break;
                }
            }

            stack.pop();
            list.add("-");
        }

        if(list.isEmpty()) {
            System.out.println("NO");
        } else {
            for (String result : list) {
                System.out.println(result);
            }
        }
    }
}
