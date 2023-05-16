class Solution {
    public int solution(int n) {
        int answer = 1;
        int cnt = 1;
        String numStr = "";

        while (true) {
            if (answer % 3 == 0) {
                answer++;
                continue;
            }

            numStr = String.valueOf(answer);
            if (numStr.contains("3")) {
                answer++;
                continue;
            }

            if(cnt == n) break;
            answer++;
            cnt++;
        }

        return answer;
    }
}