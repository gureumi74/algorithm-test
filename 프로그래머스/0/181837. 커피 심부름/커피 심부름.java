class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for (String s : order) {
            s = s.replaceAll("ice|hot", "");
            answer += 4500;
            if(s.equals("cafelatte")) {
                answer += 500;
            }
        }
        return answer;
    }
}