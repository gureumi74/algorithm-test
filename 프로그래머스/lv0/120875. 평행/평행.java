import java.util.Arrays;
class Solution {
    public int solution(int[][] dots) {
         int[][] location = new int[3][4];

        location[0] = new int[]{dots[0][0] - dots[1][0], dots[0][1] - dots[1][1], dots[2][0] - dots[3][0], dots[2][1] - dots[3][1]};
        location[1] = new int[]{dots[0][0] - dots[2][0], dots[0][1] - dots[2][1], dots[1][0] - dots[3][0], dots[1][1] - dots[3][1]};
        location[2] = new int[]{dots[0][0] - dots[3][0], dots[0][1] - dots[3][1], dots[2][0] - dots[1][0], dots[2][1] - dots[1][1]};

        for(int i = 0; i < location.length; i++) {
            if((float) location[i][1] / location[i][0] == (float) location[i][3] / location[i][2]) return 1;
        }

        return 0;
    }
}