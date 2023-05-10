import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());
        sb.reverse();
        int num1 = Integer.parseInt(sb.toString());
        sb = new StringBuilder(sc.next());
        sb.reverse();
        int num2 = Integer.parseInt(sb.toString());

        System.out.println(Math.max(num1, num2));
    }
}
