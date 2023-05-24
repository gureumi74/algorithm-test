class Solution {
    public int solution(String before, String after) {
        for(char c : after.toCharArray()) {
            before = before.replaceFirst(String.valueOf(c), "");
        }

        if(before.isEmpty()) return 1;
        return 0;   
    }
}