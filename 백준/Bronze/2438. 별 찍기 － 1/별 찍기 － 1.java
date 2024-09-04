import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = "*";
        for(int i = 0; i < N; i++) {
            System.out.println(str.repeat(i + 1));
        }
    }
}