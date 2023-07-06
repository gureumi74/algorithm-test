import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] operator = new int[4];
    static int nums[], n, operatorArr[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];;
        operatorArr = new int[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);
        System.out.println(max);
        System.out.println(min);
    }
    static void backTracking(int k) {
        if(k == n - 1) {
//            for(int i : operatorArr) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
            calculate();
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                operatorArr[k] = i;
                operator[i]--;
                backTracking(k + 1);
                operator[i]++;
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
