import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int startIdx = 1;
        int endIdx = 1;

        int cnt = 1; // n 하나만 포함하는 가지수 하나 먼저 넣은 상태로 초기화
        int sum = 1;

        while (endIdx != n) {
            if (sum == n) {
                cnt++;
                endIdx++;
                sum += endIdx;
            } else if(sum < n) {
                endIdx++;
                sum += endIdx;
            } else  {
                sum -= startIdx;
                startIdx++;
            }
        }
        System.out.println(cnt);
    }
}
