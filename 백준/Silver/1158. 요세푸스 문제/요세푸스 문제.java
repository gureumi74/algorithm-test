import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int idx = k - 1;
        int num = list.get(idx); // 초기값
        sb.append("<" + num);
        list.remove(idx);

        while (list.size() > 0) {
            idx = (idx + k - 1) % list.size();
            num = list.get(idx);
            sb.append(", " + num);
            list.remove(idx);
        }

        sb.append(">");
        System.out.println(sb);
    }
}
