import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int yAmount = 0;
        int mAmount = 0;

        for(int i = 0; i < n; i++) {
            int amount = sc.nextInt();
            yAmount += (amount / 30 + 1) * 10;
            mAmount += (amount / 60 + 1) * 15;
        }

        if(yAmount == mAmount) {
            System.out.printf("Y M %d",yAmount, mAmount);
        } else if (yAmount > mAmount) {
            System.out.printf("M %d", mAmount);
        } else System.out.printf("Y %d", yAmount);
        
    }
}