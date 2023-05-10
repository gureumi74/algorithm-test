import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(br.readLine());
        Deque deque = new ArrayDeque();
        for(int i = 0; i < caseNum; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front" :
                    deque.addFirst(input[1]);
                    break;
                case "push_back" :
                    deque.addLast(input[1]);
                    break;
                case "pop_front" :
                    if(!deque.isEmpty()) {
                        bw.write(deque.pollFirst() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;
                case "pop_back" :
                    if(!deque.isEmpty()) {
                        bw.write(deque.pollLast() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;
                case "size" :
                    bw.write(deque.size() + "\n");
                    break;
                case "empty" :
                    bw.write(deque.isEmpty() ? 1 + "\n" : 0 + "\n");
                    break;
                case "front" :
                    bw.write(deque.isEmpty() ? -1 + "\n" : deque.peekFirst() + "\n");
                    break;
                default :
                    bw.write(deque.isEmpty() ? -1 + "\n" : deque.peekLast() + "\n");
            }
        }
        bw.close();
    }
}
