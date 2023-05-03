import java.util.Arrays;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] my_stringArr = my_string.toCharArray();
        for(int i = 0; i < my_stringArr.length; i++) {
            if(my_stringArr[i] >= 65 && my_stringArr[i] < 91) {
                my_stringArr[i] += 32;
            }
        }
        Arrays.sort(my_stringArr);
        for(char i : my_stringArr) {
            answer += String.valueOf(i);
        }

        return answer;
    }
}