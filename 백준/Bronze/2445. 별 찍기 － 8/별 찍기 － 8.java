import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for(int i = 1; i <= input; i++) {
            System.out.printf("*".repeat(i));
            System.out.printf(" ".repeat((input - i) * 2));
            System.out.println("*".repeat(i));
        }
        for(int i = 1; i < input; i++) {
            System.out.print("*".repeat(input - i));
            System.out.print(" ".repeat(2 * i));
            System.out.println("*".repeat(input - i));
        }
    }
}
