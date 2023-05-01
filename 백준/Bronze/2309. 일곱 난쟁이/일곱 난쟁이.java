import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            input[i] = sc.nextInt();
            sum += input[i];
        }

        boolean flag = false;

        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if (sum - input[i] - input[j] == 100) {
                    input[i] = 100;
                    input[j] = 100;
                    flag = true;
                    break;
                }
            }
            if (flag) { break; }
        }
        Arrays.sort(input);

        for(int i = 0; i < 7; i++) {
            System.out.println(input[i]);
        }
    }
}
