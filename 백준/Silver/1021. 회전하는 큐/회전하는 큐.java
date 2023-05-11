import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int caseNum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= num; i++) {
            deque.addLast(i);
        }

        int count = 0;
        for(int i = 0; i < caseNum; i++)  {
            int target = Integer.parseInt(st.nextToken());
            int idx = 0;
            for(int k : deque) {
                if(k == target) {
                    break;
                }
                idx++;
            }

            int rotation = 0;
            if(idx <= deque.size() - idx - 1) {
                rotation = idx;
                for(int j = 0; j < rotation; j++) {
                    int n = deque.pollFirst();
                    deque.addLast(n);
                }
            } else {
                rotation = deque.size() - idx - 1;
                for(int j = 0; j <= rotation; j++) {
                    int n = deque.pollLast();
                    deque.addFirst(n);

                }
                rotation++;
            }

            deque.pollFirst();
            count += rotation;
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
