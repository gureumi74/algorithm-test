import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for(int i = 1; i <= input; i++) {
            System.out.printf(" ".repeat(input - i));
            System.out.println("*".repeat(i * 2 - 1));
        }
    }
}
