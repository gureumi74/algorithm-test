import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int cnt = 1;

        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek() == cnt) {
                stack.pop();
                cnt++;
            }

            if (num == cnt) {
                 cnt++;
            } else {
                stack.push(num);
            }
        }

        while (!stack.isEmpty() && stack.peek() == cnt) {
            stack.pop();
            cnt++;
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");


    }
}
