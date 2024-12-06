class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int xStart = 0;
        int xEnd = n - 1;
        int yStart = 0;
        int yEnd = n - 1;
        int num = 1;


        while (num <= n * n) {
            // 오른쪽 이동
            for(int i = xStart; i <= xEnd; i++) {
                answer[yStart][i] = num++;
            }
            yStart++;

            // 아래 이동
            for(int i = yStart; i <= yEnd; i++) {
                answer[i][xEnd] = num++;
            }
            xEnd--;

            // 왼쪽 이동
            for(int i = xEnd; i >= xStart; i--) {
                answer[yEnd][i] = num++;
            }
            yEnd--;

            // 위 이동
            for(int i = yEnd; i >= yStart; i--) {
                answer[i][xStart] = num++;
            }
            xStart++;

        }
        return answer;
    }
}