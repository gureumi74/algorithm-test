import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> it = list.listIterator(0);
            for (char c : input) {
                if(c == '<') {
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                } else if (c == '>') {
                    if (it.hasNext()) {
                        it.next();
                    }
                } else if (c == '-') {
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                } else {
                    it.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                sb.append(c);
            }
            bw.write(sb.toString() + "\n");
        }
        bw.close();
    }
}
