import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        String[] function;
        int arrLength;
        String str;
        Deque<Integer> deque;
        boolean isFirst;
        boolean isError;
        for(int i = 0; i < testCase; i++) {
            function = br.readLine().split("");
            arrLength = Integer.parseInt(br.readLine());
            str = br.readLine().replaceAll("[\\[|\\]]", "");
            deque = new ArrayDeque<>();
            isFirst = true;
            isError = false;
            if(!str.equals("")) {
                for (String s : str.split(",")) {
                    deque.add(Integer.parseInt(s));
                }
            }
            for (String s : function) {
                if (s.equals("R")) {
                    isFirst = !isFirst;
                } else if (deque.isEmpty()) {
                    isError = true;
                    break;
                } else {
                    if(isFirst) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            if(isError) {
                bw.write("error\n");
            } else {
                if(isFirst) {
                    bw.write(deque.toString().replaceAll(" ", "") + "\n");
                } else {
                    List<Integer> list = new ArrayList<>(deque);
                    Collections.reverse(list);
                    bw.write(list.toString().replaceAll(" ", "") + "\n");
                }
            }
        }

        bw.close();
    }
}