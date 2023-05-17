import java.util.Arrays;
class Solution {
    public int solution(int[][] dots) {
         // 기울기 공식 (y2 - y1) / (x2 - x1)
        int[][] location = new int[3][4];

        // 두 점씩 잇는 3가지 경우의 수를 담은 배열
        location[0] = new int[]{dots[0][0] - dots[1][0], dots[0][1] - dots[1][1], dots[2][0] - dots[3][0], dots[2][1] - dots[3][1]};
        location[1] = new int[]{dots[0][0] - dots[2][0], dots[0][1] - dots[2][1], dots[1][0] - dots[3][0], dots[1][1] - dots[3][1]};
        location[2] = new int[]{dots[0][0] - dots[3][0], dots[0][1] - dots[3][1], dots[2][0] - dots[1][0], dots[2][1] - dots[1][1]};

        // 배열을 돌면서 기울기 공식이 성립하는지 확인, 맞으면 1, for문이 돌아도 아니면 0 리턴
        for(int i = 0; i < location.length; i++) {
            if((float) location[i][1] / location[i][0] == (float) location[i][3] / location[i][2]) return 1;
        }

        return 0;
    }
}