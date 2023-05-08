import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCaseNum; i++) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator it = list.listIterator(0);

            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                char cmd = str.charAt(j);

                if(cmd == '<') {
                    if(it.hasPrevious()) {
                        it.previous();
                    }
                } else if(cmd == '>') {
                    if(it.hasNext()) {
                        it.next();
                    }
                } else if(cmd == '-') {
                    if(it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                } else {
                    it.add(cmd);
                }
            }

            StringBuilder sb = new StringBuilder();
            for(char c : list) {
                sb.append(c);
            }
            bw.write(sb.toString() + "\n");
        }
        bw.close();
    }
}
