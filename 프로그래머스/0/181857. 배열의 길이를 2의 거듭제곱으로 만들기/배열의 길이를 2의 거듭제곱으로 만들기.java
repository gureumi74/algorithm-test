import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int length = 1;
        
        while (arr.length > length) {
            length *= 2;
        }

        int[] answer = Arrays.copyOf(arr, length);
        return answer;
    }
}