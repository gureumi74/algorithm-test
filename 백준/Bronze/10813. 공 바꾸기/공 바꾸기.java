import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] bucket = new int[sc.nextInt()];
        int j = 1;
        for(int i = 1; i <= bucket.length; i++) {
            bucket[i - 1] = i;
        }
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int idx1 = sc.nextInt() - 1;
            int idx2 = sc.nextInt() - 1;
            int tmp = bucket[idx1];
            bucket[idx1] = bucket[idx2];
            bucket[idx2] = tmp;
        }

        for(int i = 0; i < bucket.length; i++) {
            System.out.printf("%d ", bucket[i]);
        }
    }
}
