class Solution {
    public String solution(String myString) {
        String answer = myString.replaceAll("a", "A");
        for(char c : answer.toCharArray()) {
            if(c <= 'Z' && c > 'A') {
                answer = answer.replace(c, (char) (c + 32));
            }
        }
        return answer;
    }
}