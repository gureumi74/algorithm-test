class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] boardCopy = new int[board.length + 2][board.length + 2];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 1) {
                    boardCopy[i + 1][j + 1] = 1;
                    boardCopy[i][j] = 1;
                    boardCopy[i][j + 1] = 1;
                    boardCopy[i][j + 2] = 1;
                    boardCopy[i + 1][j] = 1;
                    boardCopy[i + 1][j + 2] = 1;
                    boardCopy[i + 2][j] = 1;
                    boardCopy[i + 2][j + 1] = 1;
                    boardCopy[i + 2][j + 2] = 1;
                }
            }
        }

        for(int i = 1; i <= board.length; i++) {
            for(int j = 1; j <= board.length; j++) {
                if(boardCopy[i][j] == 0) answer++;
            }
        }
        return answer;
    }
}