class Solution {
    public int solution(String[][] board, int h, int w) {
        int[][] location = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 오른쪽 아래 왼쪽 위
        String color = board[h][w];
        int answer = 0;

        for(int i = 0; i < location.length; i++) {
            int x = h + location[i][0];
            int y = w + location[i][1];

            if(x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                if(color.equals(board[x][y])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}