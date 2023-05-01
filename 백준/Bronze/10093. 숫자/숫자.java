import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if(num1 == num2 || Math.abs(num1 - num2) == 1) {
            System.out.println(0);
        } else {
            System.out.println(Math.abs(num1 - num2)- 1);
        }
        for(int i = 1; i <= Math.abs(num1 - num2) - 1; i++) {
            System.out.printf("%d ", Math.min(num1, num2) + i);
        }
    }
}