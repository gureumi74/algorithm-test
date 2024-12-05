class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        while (myString.contains(pat)) {
            int idx = myString.indexOf(pat);
            myString = myString.substring(idx + 1, myString.length());
            answer++;
        }
        return answer;
    }
}