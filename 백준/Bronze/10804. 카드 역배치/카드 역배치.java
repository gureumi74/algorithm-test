import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] result = new int[20];
        for(int i = 0; i < 20; i++) {
            result[i] = i + 1;
        }

        for(int i = 0; i < 10; i++) {
            int[] tmp = Arrays.copyOf(result, 20);
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int count = 0;
            for(int j = 0; j < 20; j++) {
                if(start <= j && end >= j) {
                    tmp[j] = result[end - count];
                    count++;
                }
            }
            result = tmp;
         }
        for(int i = 0; i < 20; i++) {
            System.out.printf("%d ", result[i]);
        }
    }
}
