import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dice = new int[6];
    static int[][] map;
    static int N, M, x, y;
    // 0번 idx 부터 위 아래 앞 뒤 왼 오
    static int[] diceIndex = {0, 1, 2, 3, 4, 5};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 지도의 세로 크기
        M = Integer.parseInt(input[1]); // 지도의 가로 크기
        x = Integer.parseInt(input[2]); // 주사위 좌표 x
        y = Integer.parseInt(input[3]); // 주사위 좌표 y
        int k = Integer.parseInt(input[4]); // 명령의 개수
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        input = br.readLine().split(" ");
        for(int i = 0; i < k; i++) {
            diceCheck(Integer.parseInt(input[i]));
        }
    }
    static void rolling() {
        if(map[x][y] == 0) {
            map[x][y] = dice[1];
        } else {
            dice[1] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice[0]);
    }
    static void diceCheck(int n) {
        // 위 아래 앞 뒤 왼 오
        int[] copyDice = Arrays.copyOf(dice, dice.length);
        if(n == 1) { // 동쪽
            if(y + 1 == map[0].length) return;
            dice[0] = copyDice[5]; // 위 -> 오
            dice[1] = copyDice[4]; // 아래 -> 왼
            dice[4] = copyDice[0]; // 왼 -> 위
            dice[5] = copyDice[1]; // 오 -> 아래
            y++;
        } else if(n == 2) { // 서쪽
            if(y - 1 < 0) return;
            dice[0] = copyDice[4]; // 위 -> 왼
            dice[1] = copyDice[5]; // 아래 -> 오
            dice[4] = copyDice[1]; // 왼 -> 아래
            dice[5] = copyDice[0]; // 오 -> 위
            y--;
        } else if(n == 3) { // 북쪽
            if(x - 1 < 0) return;
            dice[0] = copyDice[2]; // 위 -> 앞
            dice[1] = copyDice[3]; // 아래 -> 뒤
            dice[2] = copyDice[1]; // 앞 -> 아래
            dice[3] = copyDice[0]; // 뒤 -> 위
            x--;
        } else { // 남쪽
            if(x + 1 == map.length) return;
            dice[0] = copyDice[3]; // 위 -> 뒤
            dice[1] = copyDice[2]; // 아래 -> 앞
            dice[2] = copyDice[0]; // 앞 -> 위
            dice[3] = copyDice[1]; // 뒤 -> 아래
            x++;
        }

        rolling();
    }
}
