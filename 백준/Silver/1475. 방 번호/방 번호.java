import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numCount = new int[9];
        int inputNum = sc.nextInt();
        while (inputNum > 0) {
            if(inputNum % 10 == 9) numCount[6]++;
            else numCount[inputNum % 10]++;
            inputNum /= 10;
        }
        numCount[6] = (int) Math.round(numCount[6] / 2.0);
        Arrays.sort(numCount);
        System.out.println(numCount[8]);
    }
}
