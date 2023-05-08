import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> list = new LinkedList<>();
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        ListIterator<Character> it = list.listIterator(list.size());
        int instructionN = Integer.parseInt(br.readLine());
        while (instructionN-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if(cmd[0].equals("L")) {
                if(it.hasPrevious()) {
                    it.previous();
                }
            } else if (cmd[0].equals("D")) {
                if (it.hasNext()) {
                    it.next();
                }
            } else if(cmd[0].equals("B")) {
                if(it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else if (cmd[0].equals("P")) {
                char c = cmd[1].charAt(0);
                it.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
