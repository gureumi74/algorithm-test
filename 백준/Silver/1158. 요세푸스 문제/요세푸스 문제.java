import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int inputNum = Integer.parseInt(input[0]);
        int deleteNum = Integer.parseInt(input[1]);

        Node head = new Node(1);
        Node cur = head;
        for(int i = 2; i <= inputNum; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head;

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        // 리스트에 한 명만 남을 때까지 반복
        while (cur != cur.next) {
            for(int i = 0; i < deleteNum - 1; i++) {
                cur = cur.next;
            }
            sb.append(cur.next.value).append(", ");
            cur.next = cur.next.next;
        }

        sb.append(cur.value).append(">");
        System.out.println(sb.toString());
    }
}