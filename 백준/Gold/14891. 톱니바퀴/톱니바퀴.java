import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] wheel = new int[4][8], copyWheel = new int[4][8];
    static int wheelNum, direction;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(input[j]);
            }
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wheelNum = Integer.parseInt(st.nextToken()) - 1;
            direction = Integer.parseInt(st.nextToken());
            gear();
        }

        int result = 0;
        for(int i = 0; i < 4; i++) {
            if(wheel[i][0] == 1) {
                result += 1 << i;
            }
        }
        System.out.println(result);
    }
    static void gear() {
        int[] check = new int[4];
        check[wheelNum] = direction;
        int left = wheel[wheelNum][6];
        int right = wheel[wheelNum][2];
        rotation(wheelNum, direction);

        for(int i = wheelNum; i < 3; i++) {
            if(check[i] == 0) break;
            if(right != wheel[i + 1][6]) {
                int tmpDirection;
                if(check[i] == 1) tmpDirection = -1;
                else tmpDirection = 1;
                right = wheel[i + 1][2];

                rotation(i + 1, tmpDirection);
                check[i + 1] = tmpDirection;
            }
        }

        for(int i = wheelNum; i > 0; i--) {
            if(check[i] == 0) break;
            if(left != wheel[i - 1][2]) {
                int tmpDirection;
                if(check[i] == 1) tmpDirection = -1;
                else tmpDirection = 1;

                left = wheel[i - 1][6];
                rotation(i - 1, tmpDirection);
                check[i - 1] = tmpDirection;
            }
        }


    }
    static void rotation(int num, int gearDirection) {
        if(gearDirection == -1) {
            int tmp = wheel[num][0];
            for(int i = 0; i < 7; i++) {
                wheel[num][i] = wheel[num][i + 1];
            }
            wheel[num][7] = tmp;
        } else {
            int tmp = wheel[num][7];
            for(int i = 7; i > 0; i--) {
                wheel[num][i] = wheel[num][i - 1];
            }
            wheel[num][0] = tmp;
        }

//        for(int i = 0; i < 4; i++) {
//            System.out.println(Arrays.toString(wheel[i]));
//        }
//        System.out.println();
    }
}
