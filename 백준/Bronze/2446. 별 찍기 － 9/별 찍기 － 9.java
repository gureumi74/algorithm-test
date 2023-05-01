import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for(int i = 0; i < input - 1; i++) {
            System.out.printf(" ".repeat(i));
            System.out.println("*".repeat((input - i) * 2 - 1));
        }
        for(int i = 1; i <= input; i++) {
            System.out.printf(" ".repeat(input - i));
            System.out.println("*".repeat(2 * i - 1));
        }
    }
}
