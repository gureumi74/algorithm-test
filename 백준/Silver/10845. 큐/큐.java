import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < caseNum; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push" :
                    queue.add(Integer.parseInt(input[1]));
                    break;
                case "pop" :
                    if (queue.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(queue.poll() + "\n");
                    }
                    break;
                case "size" :
                    bw.write(queue.size() + "\n");
                    break;
                case "empty" :
                    bw.write(queue.isEmpty() ? 1 + "\n" : 0 + "\n");
                    break;
                case "front" :
                    if(queue.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(queue.peek() + "\n");
                    }
                    break;
                default: // back 인 경우
                    if(queue.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(((LinkedList<Integer>) queue).getLast() + "\n");
                    }
                    break;
            }
        }
        bw.close();
    }
}
