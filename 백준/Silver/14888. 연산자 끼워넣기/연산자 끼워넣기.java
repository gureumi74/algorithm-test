
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] operator;
    static int nums[], n, operatorArr[];
    static boolean visit[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];;
        operator = new int[n - 1];
        operatorArr = new int[n - 1];
        visit = new boolean[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            for(int j = 0; j < tmp; j++) {
                operator[count++] = i;
            }
        }

        backTracking(0);
        System.out.println(max);
        System.out.println(min);
    }
    static void backTracking(int k) {
        if(k == n - 1) {
            calculate();
//                for (int i : operatorArr) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
            return;
        }

        for(int i = 0; i < n - 1; i++) {
            if(!visit[i]) {
                operatorArr[k] = operator[i];
                visit[i] = true;
                backTracking(k + 1);
                visit[i] = false;
            }
        }
    }
    static void calculate() {
        int result = nums[0];

        for(int i = 0; i < n - 1; i++) {
            int tmp = operatorArr[i];
            if(tmp == 0) {
                result += nums[i + 1];
            } else if(tmp == 1) {
                result -= nums[i + 1];
            } else if(tmp == 2) {
                result *= nums[i + 1];
            } else if(tmp == 3) {
                if(result < 0) {
                    result *= -1;
                    result /= nums[i + 1];
                    result *= -1;
                } else
                    result /= nums[i + 1];
            }
        }

//        System.out.println(result);
        if (result > max) max = result;
        if (result < min) min = result;
    }
}
