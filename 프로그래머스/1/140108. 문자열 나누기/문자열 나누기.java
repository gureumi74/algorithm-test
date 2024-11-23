class Solution {
    public int solution(String s) {
        int answer = 1;
        char x = s.charAt(0);
        int sameCnt = 0;
        int diffCnt = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == x) {
                sameCnt++;
            } else {
                diffCnt++;
            }

            if(sameCnt == diffCnt && i < s.length() - 1) {
                answer++;
                sameCnt = 0;
                diffCnt = 0;
                x = s.charAt(i + 1);
            }
        }

        return answer;
    }
}