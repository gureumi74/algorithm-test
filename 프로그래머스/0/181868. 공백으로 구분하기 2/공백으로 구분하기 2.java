class Solution {
    public String[] solution(String my_string) {
        my_string = my_string.replaceAll("[ ]+", " ");
        if(my_string.charAt(0) == ' ') {
            my_string = my_string.substring(1, my_string.length());
        }
        String[] answer = my_string.split(" ");
        return answer;
    }
}