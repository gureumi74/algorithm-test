import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->
        {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                queue.add(num);
            } else {
                if(queue.isEmpty()) {
                    bw.write(String.valueOf(0) + "\n");
                } else {
                    bw.write(String.valueOf(queue.poll()) + "\n");
                }
            }
        }
        
        bw.close();
    }
}
