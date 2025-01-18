import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        Deque<Node> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.getLast().val > cur) {
                deque.removeLast();
            }
            deque.addLast(new Node(i, cur));

            // 범위 벗어나는 값은 덱에서 제거하기
            if (deque.getFirst().idx <= i - l) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().val + " ");
        }
        bw.close();
    }
}
