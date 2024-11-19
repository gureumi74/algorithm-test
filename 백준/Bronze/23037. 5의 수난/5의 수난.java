import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        while (n > 0) {
            result += (int) Math.pow(n % 10, 5);
            n /= 10;
        }

        System.out.println(result);
    }
}
