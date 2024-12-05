class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replaceAll("A", "a").replaceAll("B", "A").replaceAll("a", "B");
        return myString.contains(pat) ? 1 : 0;
    }
}