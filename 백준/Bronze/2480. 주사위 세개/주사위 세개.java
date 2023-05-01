import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);
        if (num[0] == num[2]) {
            System.out.println(num[0] * 1000 + 10000);
        } else if (num[0] == num[1] || num[1] == num[2]) {
            System.out.println(num[1] * 100 + 1000);
        } else {
            System.out.println(num[2] * 100);
        }

    }
}
