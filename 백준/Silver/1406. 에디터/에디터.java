import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<Character> strList = new LinkedList<>();
        for (char c : str.toCharArray()) {
            strList.add(c);
        }
        int n = Integer.parseInt(br.readLine());
        ListIterator<Character> it = strList.listIterator(strList.size());

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            if (input[0] == 'L') {
                if (it.hasPrevious()) {
                    it.previous();
                }
            } else if (input[0] == 'D') {
                if (it.hasNext()) {
                    it.next();
                }
            } else if (input[0] == 'B') {
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else if (input[0] == 'P'){
                it.add(input[2]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : strList) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
