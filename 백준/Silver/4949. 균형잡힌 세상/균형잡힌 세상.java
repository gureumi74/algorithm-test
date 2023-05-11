import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');

        while (true) {
            String input = br.readLine();
            if(input.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean check = false;
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                switch (c) {
                    case '(' :
                    case '[' :
                        stack.push(c);
                        break;
                    case ')' :
                    case ']' :
                        if(!stack.empty() && stack.peek() == map.get(c)) {
                            stack.pop();
                        } else {
                            check = true;
                        }
                        break;
                    default:
                }
                if(check) break;
            }
            if(check || !stack.empty()) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}
