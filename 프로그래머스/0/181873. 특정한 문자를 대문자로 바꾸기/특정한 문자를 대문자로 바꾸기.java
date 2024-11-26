class Solution {
    public String solution(String my_string, String alp) {
        return my_string.replaceAll(alp, String.valueOf((char)(alp.charAt(0) - 32)));
    }
}